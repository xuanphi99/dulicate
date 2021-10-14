package com.dogoo.poc.pet.rest.resource.v1_0.test;

import com.dogoo.poc.pet.rest.client.dto.v1_0.Pet;
import com.dogoo.poc.pet.rest.client.http.HttpInvoker;
import com.dogoo.poc.pet.rest.client.pagination.Page;
import com.dogoo.poc.pet.rest.client.pagination.Pagination;
import com.dogoo.poc.pet.rest.client.resource.v1_0.PetResource;
import com.dogoo.poc.pet.rest.client.serdes.v1_0.PetSerDes;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
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
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
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
 * @author khoavu
 * @generated
 */
@Generated("")
public abstract class BasePetResourceTestCase {

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

		_petResource.setContextCompany(testCompany);

		PetResource.Builder builder = PetResource.builder();

		petResource = builder.authentication(
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

		Pet pet1 = randomPet();

		String json = objectMapper.writeValueAsString(pet1);

		Pet pet2 = PetSerDes.toDTO(json);

		Assert.assertTrue(equals(pet1, pet2));
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

		Pet pet = randomPet();

		String json1 = objectMapper.writeValueAsString(pet);
		String json2 = PetSerDes.toJSON(pet);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Pet pet = randomPet();

		pet.setName(regex);
		pet.setStatusDate(regex);
		pet.setTag(regex);

		String json = PetSerDes.toJSON(pet);

		Assert.assertFalse(json.contains(regex));

		pet = PetSerDes.toDTO(json);

		Assert.assertEquals(regex, pet.getName());
		Assert.assertEquals(regex, pet.getStatusDate());
		Assert.assertEquals(regex, pet.getTag());
	}

	@Test
	public void testGetPetsPage() throws Exception {
		Page<Pet> page = petResource.getPetsPage(
			RandomTestUtil.randomString(), null, Pagination.of(1, 2), null);

		Assert.assertEquals(0, page.getTotalCount());

		Pet pet1 = testGetPetsPage_addPet(randomPet());

		Pet pet2 = testGetPetsPage_addPet(randomPet());

		page = petResource.getPetsPage(null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(pet1, pet2), (List<Pet>)page.getItems());
		assertValid(page);

		petResource.deletePet(pet1.getId());

		petResource.deletePet(pet2.getId());
	}

	@Test
	public void testGetPetsPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Pet pet1 = randomPet();

		pet1 = testGetPetsPage_addPet(pet1);

		for (EntityField entityField : entityFields) {
			Page<Pet> page = petResource.getPetsPage(
				null, getFilterString(entityField, "between", pet1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(pet1), (List<Pet>)page.getItems());
		}
	}

	@Test
	public void testGetPetsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Pet pet1 = testGetPetsPage_addPet(randomPet());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Pet pet2 = testGetPetsPage_addPet(randomPet());

		for (EntityField entityField : entityFields) {
			Page<Pet> page = petResource.getPetsPage(
				null, getFilterString(entityField, "eq", pet1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(pet1), (List<Pet>)page.getItems());
		}
	}

	@Test
	public void testGetPetsPageWithPagination() throws Exception {
		Pet pet1 = testGetPetsPage_addPet(randomPet());

		Pet pet2 = testGetPetsPage_addPet(randomPet());

		Pet pet3 = testGetPetsPage_addPet(randomPet());

		Page<Pet> page1 = petResource.getPetsPage(
			null, null, Pagination.of(1, 2), null);

		List<Pet> pets1 = (List<Pet>)page1.getItems();

		Assert.assertEquals(pets1.toString(), 2, pets1.size());

		Page<Pet> page2 = petResource.getPetsPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Pet> pets2 = (List<Pet>)page2.getItems();

		Assert.assertEquals(pets2.toString(), 1, pets2.size());

		Page<Pet> page3 = petResource.getPetsPage(
			null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(pet1, pet2, pet3), (List<Pet>)page3.getItems());
	}

	@Test
	public void testGetPetsPageWithSortDateTime() throws Exception {
		testGetPetsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, pet1, pet2) -> {
				BeanUtils.setProperty(
					pet1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetPetsPageWithSortInteger() throws Exception {
		testGetPetsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, pet1, pet2) -> {
				BeanUtils.setProperty(pet1, entityField.getName(), 0);
				BeanUtils.setProperty(pet2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetPetsPageWithSortString() throws Exception {
		testGetPetsPageWithSort(
			EntityField.Type.STRING,
			(entityField, pet1, pet2) -> {
				Class<?> clazz = pet1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						pet1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						pet2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						pet1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						pet2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						pet1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						pet2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetPetsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Pet, Pet, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Pet pet1 = randomPet();
		Pet pet2 = randomPet();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, pet1, pet2);
		}

		pet1 = testGetPetsPage_addPet(pet1);

		pet2 = testGetPetsPage_addPet(pet2);

		for (EntityField entityField : entityFields) {
			Page<Pet> ascPage = petResource.getPetsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(pet1, pet2), (List<Pet>)ascPage.getItems());

			Page<Pet> descPage = petResource.getPetsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(pet2, pet1), (List<Pet>)descPage.getItems());
		}
	}

	protected Pet testGetPetsPage_addPet(Pet pet) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetPetsPage() throws Exception {
		GraphQLField graphQLField = new GraphQLField(
			"pets",
			new HashMap<String, Object>() {
				{
					put("page", 1);
					put("pageSize", 2);
				}
			},
			new GraphQLField("items", getGraphQLFields()),
			new GraphQLField("page"), new GraphQLField("totalCount"));

		JSONObject petsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/pets");

		Assert.assertEquals(0, petsJSONObject.get("totalCount"));

		Pet pet1 = testGraphQLPet_addPet();
		Pet pet2 = testGraphQLPet_addPet();

		petsJSONObject = JSONUtil.getValueAsJSONObject(
			invokeGraphQLQuery(graphQLField), "JSONObject/data",
			"JSONObject/pets");

		Assert.assertEquals(2, petsJSONObject.get("totalCount"));

		assertEqualsIgnoringOrder(
			Arrays.asList(pet1, pet2),
			Arrays.asList(PetSerDes.toDTOs(petsJSONObject.getString("items"))));
	}

	@Test
	public void testPostPet() throws Exception {
		Pet randomPet = randomPet();

		Pet postPet = testPostPet_addPet(randomPet);

		assertEquals(randomPet, postPet);
		assertValid(postPet);
	}

	protected Pet testPostPet_addPet(Pet pet) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeletePet() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		Pet pet = testDeletePet_addPet();

		assertHttpResponseStatusCode(
			204, petResource.deletePetHttpResponse(pet.getId()));

		assertHttpResponseStatusCode(
			404, petResource.getPetHttpResponse(pet.getId()));

		assertHttpResponseStatusCode(404, petResource.getPetHttpResponse(0L));
	}

	protected Pet testDeletePet_addPet() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLDeletePet() throws Exception {
		Pet pet = testGraphQLPet_addPet();

		Assert.assertTrue(
			JSONUtil.getValueAsBoolean(
				invokeGraphQLMutation(
					new GraphQLField(
						"deletePet",
						new HashMap<String, Object>() {
							{
								put("petId", pet.getId());
							}
						})),
				"JSONObject/data", "Object/deletePet"));

		JSONArray errorsJSONArray = JSONUtil.getValueAsJSONArray(
			invokeGraphQLQuery(
				new GraphQLField(
					"pet",
					new HashMap<String, Object>() {
						{
							put("petId", pet.getId());
						}
					},
					new GraphQLField("id"))),
			"JSONArray/errors");

		Assert.assertTrue(errorsJSONArray.length() > 0);
	}

	@Test
	public void testGetPet() throws Exception {
		Pet postPet = testGetPet_addPet();

		Pet getPet = petResource.getPet(postPet.getId());

		assertEquals(postPet, getPet);
		assertValid(getPet);
	}

	protected Pet testGetPet_addPet() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetPet() throws Exception {
		Pet pet = testGraphQLPet_addPet();

		Assert.assertTrue(
			equals(
				pet,
				PetSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"pet",
								new HashMap<String, Object>() {
									{
										put("petId", pet.getId());
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/pet"))));
	}

	@Test
	public void testGraphQLGetPetNotFound() throws Exception {
		Long irrelevantPetId = RandomTestUtil.randomLong();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"pet",
						new HashMap<String, Object>() {
							{
								put("petId", irrelevantPetId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testPathPet() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPutPet() throws Exception {
		Pet postPet = testPutPet_addPet();

		Pet randomPet = randomPet();

		Pet putPet = petResource.putPet(postPet.getId(), randomPet);

		assertEquals(randomPet, putPet);
		assertValid(putPet);

		Pet getPet = petResource.getPet(putPet.getId());

		assertEquals(randomPet, getPet);
		assertValid(getPet);
	}

	protected Pet testPutPet_addPet() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

	protected Pet testGraphQLPet_addPet() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Pet pet1, Pet pet2) {
		Assert.assertTrue(pet1 + " does not equal " + pet2, equals(pet1, pet2));
	}

	protected void assertEquals(List<Pet> pets1, List<Pet> pets2) {
		Assert.assertEquals(pets1.size(), pets2.size());

		for (int i = 0; i < pets1.size(); i++) {
			Pet pet1 = pets1.get(i);
			Pet pet2 = pets2.get(i);

			assertEquals(pet1, pet2);
		}
	}

	protected void assertEqualsIgnoringOrder(List<Pet> pets1, List<Pet> pets2) {
		Assert.assertEquals(pets1.size(), pets2.size());

		for (Pet pet1 : pets1) {
			boolean contains = false;

			for (Pet pet2 : pets2) {
				if (equals(pet1, pet2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(pets2 + " does not contain " + pet1, contains);
		}
	}

	protected void assertValid(Pet pet) throws Exception {
		boolean valid = true;

		if (pet.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (pet.getCreator() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (pet.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (pet.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("statusDate", additionalAssertFieldName)) {
				if (pet.getStatusDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tag", additionalAssertFieldName)) {
				if (pet.getTag() == null) {
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

	protected void assertValid(Page<Pet> page) {
		boolean valid = false;

		java.util.Collection<Pet> pets = page.getItems();

		int size = pets.size();

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
				getDeclaredFields(com.dogoo.poc.pet.rest.dto.v1_0.Pet.class)) {

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

	protected boolean equals(Pet pet1, Pet pet2) {
		if (pet1 == pet2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("creator", additionalAssertFieldName)) {
				if (!Objects.deepEquals(pet1.getCreator(), pet2.getCreator())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(pet1.getId(), pet2.getId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(pet1.getName(), pet2.getName())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(pet1.getStatus(), pet2.getStatus())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("statusDate", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						pet1.getStatusDate(), pet2.getStatusDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tag", additionalAssertFieldName)) {
				if (!Objects.deepEquals(pet1.getTag(), pet2.getTag())) {
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

		if (!(_petResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_petResource;

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
		EntityField entityField, String operator, Pet pet) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("creator")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(pet.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("status")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("statusDate")) {
			sb.append("'");
			sb.append(String.valueOf(pet.getStatusDate()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("tag")) {
			sb.append("'");
			sb.append(String.valueOf(pet.getTag()));
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

	protected Pet randomPet() throws Exception {
		return new Pet() {
			{
				id = RandomTestUtil.randomLong();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				statusDate = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				tag = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected Pet randomIrrelevantPet() throws Exception {
		Pet randomIrrelevantPet = randomPet();

		return randomIrrelevantPet;
	}

	protected Pet randomPatchPet() throws Exception {
		return randomPet();
	}

	protected PetResource petResource;
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
		BasePetResourceTestCase.class);

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
	private com.dogoo.poc.pet.rest.resource.v1_0.PetResource _petResource;

}