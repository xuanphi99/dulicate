package com.dogoo.employee.rest.client.serdes.v1_0;

import com.dogoo.employee.rest.client.dto.v1_0.Employee;
import com.dogoo.employee.rest.client.json.BaseJSONParser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author longnv
 * @generated
 */
@Generated("")
public class EmployeeSerDes {

	public static Employee toDTO(String json) {
		EmployeeJSONParser employeeJSONParser = new EmployeeJSONParser();

		return employeeJSONParser.parseToDTO(json);
	}

	public static Employee[] toDTOs(String json) {
		EmployeeJSONParser employeeJSONParser = new EmployeeJSONParser();

		return employeeJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Employee employee) {
		if (employee == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (employee.getAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"address\": ");

			sb.append("\"");

			sb.append(_escape(employee.getAddress()));

			sb.append("\"");
		}

		if (employee.getBirthDay() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"birthDay\": ");

			sb.append("\"");

			sb.append(liferayToJSONDateFormat.format(employee.getBirthDay()));

			sb.append("\"");
		}

		if (employee.getGender() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"gender\": ");

			sb.append(employee.getGender());
		}

		if (employee.getHasAccount() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hasAccount\": ");

			sb.append(employee.getHasAccount());
		}

		if (employee.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append("\"");

			sb.append(_escape(employee.getId()));

			sb.append("\"");
		}

		if (employee.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(employee.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		EmployeeJSONParser employeeJSONParser = new EmployeeJSONParser();

		return employeeJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Employee employee) {
		if (employee == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		DateFormat liferayToJSONDateFormat = new SimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");

		if (employee.getAddress() == null) {
			map.put("address", null);
		}
		else {
			map.put("address", String.valueOf(employee.getAddress()));
		}

		if (employee.getBirthDay() == null) {
			map.put("birthDay", null);
		}
		else {
			map.put(
				"birthDay",
				liferayToJSONDateFormat.format(employee.getBirthDay()));
		}

		if (employee.getGender() == null) {
			map.put("gender", null);
		}
		else {
			map.put("gender", String.valueOf(employee.getGender()));
		}

		if (employee.getHasAccount() == null) {
			map.put("hasAccount", null);
		}
		else {
			map.put("hasAccount", String.valueOf(employee.getHasAccount()));
		}

		if (employee.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(employee.getId()));
		}

		if (employee.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(employee.getName()));
		}

		return map;
	}

	public static class EmployeeJSONParser extends BaseJSONParser<Employee> {

		@Override
		protected Employee createDTO() {
			return new Employee();
		}

		@Override
		protected Employee[] createDTOArray(int size) {
			return new Employee[size];
		}

		@Override
		protected void setField(
			Employee employee, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "address")) {
				if (jsonParserFieldValue != null) {
					employee.setAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "birthDay")) {
				if (jsonParserFieldValue != null) {
					employee.setBirthDay(toDate((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "gender")) {
				if (jsonParserFieldValue != null) {
					employee.setGender(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "hasAccount")) {
				if (jsonParserFieldValue != null) {
					employee.setHasAccount((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					employee.setId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					employee.setName((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}