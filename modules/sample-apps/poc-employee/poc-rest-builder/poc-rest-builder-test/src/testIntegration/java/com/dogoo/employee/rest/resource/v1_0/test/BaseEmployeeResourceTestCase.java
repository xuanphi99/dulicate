package com.dogoo.employee.rest.resource.v1_0.test;

import com.dogoo.employee.rest.client.dto.v1_0.Employee;
import com.dogoo.employee.rest.client.http.HttpInvoker;
import com.dogoo.employee.rest.client.pagination.Page;
import com.dogoo.employee.rest.client.resource.v1_0.EmployeeResource;
import com.dogoo.employee.rest.client.serdes.v1_0.EmployeeSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author longnv
 * @generated
 */
@Generated("")
public abstract class BaseEmployeeResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_employeeResource.setContextCompany(testCompany);

		EmployeeResource.Builder builder = EmployeeResource.builder();

		employeeResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Employee employee1 = randomEmployee();

		String json = objectMapper.writeValueAsString(employee1);

		Employee employee2 = EmployeeSerDes.toDTO(json);

		Assert.assertTrue(equals(employee1, employee2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Employee employee = randomEmployee();

		String json1 = objectMapper.writeValueAsString(employee);
		String json2 = EmployeeSerDes.toJSON(employee);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Employee employee = randomEmployee();

		employee.setAddress(regex);
		employee.setId(regex);
		employee.setName(regex);

		String json = EmployeeSerDes.toJSON(employee);

		Assert.assertFalse(json.contains(regex));

		employee = EmployeeSerDes.toDTO(json);

		Assert.assertEquals(regex, employee.getAddress());
		Assert.assertEquals(regex, employee.getId());
		Assert.assertEquals(regex, employee.getName());
	}

	@Test
	public void testDeleteEmployee() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Employee employee = testDeleteEmployee_addEmployee();

		assertHttpResponseStatusCode(
			204, employeeResource.deleteEmployeeHttpResponse(employee.getId()));

		assertHttpResponseStatusCode(
			404, employeeResource.getEmployeeHttpResponse(employee.getId()));

		assertHttpResponseStatusCode(
			404, employeeResource.getEmployeeHttpResponse("-"));
	}

	protected Employee testDeleteEmployee_addEmployee() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeleteEmployee() throws Exception {
		Employee employee = testGraphQLEmployee_addEmployee();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deleteEmployee",
						new HashMap<String, Object>() {
							{
								put(
									"employeeId",
									"\"" + employee.getId() + "\"");
							}
						})),
				"JSONObject/data", "Object/deleteEmployee"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"employee",
					new HashMap<String, Object>() {
						{
							put("employeeId", "\"" + employee.getId() + "\"");
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetEmployee() throws Exception {
		Employee postEmployee = testGetEmployee_addEmployee();

		Employee getEmployee = employeeResource.getEmployee(
			postEmployee.getId());

		assertEquals(postEmployee, getEmployee);
		assertValid(getEmployee);
	}

	protected Employee testGetEmployee_addEmployee() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetEmployee() throws Exception {
		Employee employee = testGraphQLEmployee_addEmployee();

		Assert.assertTrue(
			equals(
				employee,
				EmployeeSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"employee",
								new HashMap<String, Object>() {
									{
										put(
											"employeeId",
											"\"" + employee.getId() + "\"");
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/employee"))));
	}

	@Test
	public void testGraphQLGetEmployeeNotFound() throws Exception {
		String irrelevantEmployeeId =
			"\"" + RandomTestUtil.randomString() + "\"";

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"employee",
						new HashMap<String, Object>() {
							{
								put("employeeId", irrelevantEmployeeId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPutEmployee() throws Exception {
		Employee postEmployee = testPutEmployee_addEmployee();

		Employee randomEmployee = randomEmployee();

		Employee putEmployee = employeeResource.putEmployee(
			postEmployee.getId(), randomEmployee);

		assertEquals(randomEmployee, putEmployee);
		assertValid(putEmployee);

		Employee getEmployee = employeeResource.getEmployee(
			putEmployee.getId());

		assertEquals(randomEmployee, getEmployee);
		assertValid(getEmployee);
	}

	protected Employee testPutEmployee_addEmployee() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetEmployees() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetEmployees() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"employees",
			new HashMap<String, Object>() {
				{
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject employeesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/employees");

		Assert.assertEquals(0, employeesJSONObject.get("totalCount"));

		Employee employee1 = testGraphQLEmployee_addEmployee();
		Employee employee2 = testGraphQLEmployee_addEmployee();

		employeesJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/employees");

		Assert.assertEquals(2, employeesJSONObject.get("totalCount"));

		assertEqualsIgnoringOrder(
			Arrays.asList(employee1, employee2),
			Arrays.asList(
				EmployeeSerDes.toDTOs(employeesJSONObject.getString("items"))));
	}

	@Test
	public void testAddEmployee() throws Exception {
		Employee randomEmployee = randomEmployee();

		Employee postEmployee = testAddEmployee_addEmployee(randomEmployee);

		assertEquals(randomEmployee, postEmployee);
		assertValid(postEmployee);
	}

	protected Employee testAddEmployee_addEmployee(Employee employee)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Employee testGraphQLEmployee_addEmployee() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Employee employee1, Employee employee2) {
		Assert.assertTrue(
			employee1 + " does not equal " + employee2,
			equals(employee1, employee2));
	}

	protected void assertEquals(
		List<Employee> employees1, List<Employee> employees2) {

		Assert.assertEquals(employees1.size(), employees2.size());

		for (int i = 0; i < employees1.size(); i++) {
			Employee employee1 = employees1.get(i);
			Employee employee2 = employees2.get(i);

			assertEquals(employee1, employee2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Employee> employees1, List<Employee> employees2) {

		Assert.assertEquals(employees1.size(), employees2.size());

		for (Employee employee1 : employees1) {
			boolean contains = false;

			for (Employee employee2 : employees2) {
				if (equals(employee1, employee2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				employees2 + " does not contain " + employee1, contains);
		}
	}

	protected void assertValid(Employee employee) throws Exception {
		boolean valid = true;

		if (employee.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (employee.getAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("birthDay", additionalAssertFieldName)) {
				if (employee.getBirthDay() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("gender", additionalAssertFieldName)) {
				if (employee.getGender() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("hasAccount", additionalAssertFieldName)) {
				if (employee.getHasAccount() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (employee.getName() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Employee> page) {
		boolean valid = false;

		java.util.Collection<Employee> employees = page.getItems();

		int size = employees.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field :
				getDeclaredFields(
					com.dogoo.employee.rest.dto.v1_0.Employee.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Employee employee1, Employee employee2) {
		if (employee1 == employee2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("address", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employee1.getAddress(), employee2.getAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("birthDay", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employee1.getBirthDay(), employee2.getBirthDay())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("gender", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employee1.getGender(), employee2.getGender())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("hasAccount", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employee1.getHasAccount(), employee2.getHasAccount())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(employee1.getId(), employee2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						employee1.getName(), employee2.getName())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected Field[] getDeclaredFields(Class clazz) throws Exception {
		Stream<Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_employeeResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_employeeResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Employee employee) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("address")) {
			sb.append("'");
			sb.append(String.valueOf(employee.getAddress()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("birthDay")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(employee.getBirthDay(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(employee.getBirthDay(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(employee.getBirthDay()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("gender")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("hasAccount")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			sb.append("'");
			sb.append(String.valueOf(employee.getId()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(employee.getName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected Employee randomEmployee() throws Exception {
		return new Employee() {
			{
				address = StringUtil.toLowerCase(RandomTestUtil.randomString());
				birthDay = RandomTestUtil.nextDate();
				gender = RandomTestUtil.randomInt();
				hasAccount = RandomTestUtil.randomBoolean();
				id = StringUtil.toLowerCase(RandomTestUtil.randomString());
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Employee randomIrrelevantEmployee() throws Exception {
		Employee randomIrrelevantEmployee = randomEmployee();

		return randomIrrelevantEmployee;
	}

	protected Employee randomPatchEmployee() throws Exception {
		return randomEmployee();
	}

	protected EmployeeResource employeeResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseEmployeeResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.dogoo.employee.rest.resource.v1_0.EmployeeResource
		_employeeResource;

}