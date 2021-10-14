package com.dogoo.poc.pet.rest.client.serdes.v1_0;

import com.dogoo.poc.pet.rest.client.dto.v1_0.Pet;
import com.dogoo.poc.pet.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author khoavu
 * @generated
 */
@Generated("")
public class PetSerDes {

	public static Pet toDTO(String json) {
		PetJSONParser petJSONParser = new PetJSONParser();

		return petJSONParser.parseToDTO(json);
	}

	public static Pet[] toDTOs(String json) {
		PetJSONParser petJSONParser = new PetJSONParser();

		return petJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Pet pet) {
		if (pet == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (pet.getCreator() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"creator\": ");

			sb.append(String.valueOf(pet.getCreator()));
		}

		if (pet.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(pet.getId());
		}

		if (pet.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(pet.getName()));

			sb.append("\"");
		}

		if (pet.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(pet.getStatus());

			sb.append("\"");
		}

		if (pet.getStatusDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statusDate\": ");

			sb.append("\"");

			sb.append(_escape(pet.getStatusDate()));

			sb.append("\"");
		}

		if (pet.getTag() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tag\": ");

			sb.append("\"");

			sb.append(_escape(pet.getTag()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PetJSONParser petJSONParser = new PetJSONParser();

		return petJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Pet pet) {
		if (pet == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (pet.getCreator() == null) {
			map.put("creator", null);
		}
		else {
			map.put("creator", String.valueOf(pet.getCreator()));
		}

		if (pet.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(pet.getId()));
		}

		if (pet.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(pet.getName()));
		}

		if (pet.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(pet.getStatus()));
		}

		if (pet.getStatusDate() == null) {
			map.put("statusDate", null);
		}
		else {
			map.put("statusDate", String.valueOf(pet.getStatusDate()));
		}

		if (pet.getTag() == null) {
			map.put("tag", null);
		}
		else {
			map.put("tag", String.valueOf(pet.getTag()));
		}

		return map;
	}

	public static class PetJSONParser extends BaseJSONParser<Pet> {

		@Override
		protected Pet createDTO() {
			return new Pet();
		}

		@Override
		protected Pet[] createDTOArray(int size) {
			return new Pet[size];
		}

		@Override
		protected void setField(
			Pet pet, String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "creator")) {
				if (jsonParserFieldValue != null) {
					pet.setCreator(
						CreatorSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					pet.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					pet.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					pet.setStatus(
						Pet.Status.create((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statusDate")) {
				if (jsonParserFieldValue != null) {
					pet.setStatusDate((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tag")) {
				if (jsonParserFieldValue != null) {
					pet.setTag((String)jsonParserFieldValue);
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