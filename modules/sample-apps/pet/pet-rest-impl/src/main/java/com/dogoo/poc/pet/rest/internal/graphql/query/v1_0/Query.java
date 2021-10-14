package com.dogoo.poc.pet.rest.internal.graphql.query.v1_0;

import com.dogoo.poc.pet.rest.dto.v1_0.Pet;
import com.dogoo.poc.pet.rest.resource.v1_0.PetResource;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author khoavu
 * @generated
 */
@Generated("")
public class Query {

	public static void setPetResourceComponentServiceObjects(
		ComponentServiceObjects<PetResource>
			petResourceComponentServiceObjects) {

		_petResourceComponentServiceObjects =
			petResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {pets(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieves the pets. Results can be paginated, filtered, searched, and sorted."
	)
	public PetPage pets(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_petResourceComponentServiceObjects, this::_populateResourceContext,
			petResource -> new PetPage(
				petResource.getPetsPage(
					search, _filterBiFunction.apply(petResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(petResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {pet(petId: ___){id, name, tag, status, statusDate, creator}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Info for a specific pet")
	public Pet pet(@GraphQLName("petId") Long petId) throws Exception {
		return _applyComponentServiceObjects(
			_petResourceComponentServiceObjects, this::_populateResourceContext,
			petResource -> petResource.getPet(petId));
	}

	@GraphQLName("PetPage")
	public class PetPage {

		public PetPage(Page petPage) {
			actions = petPage.getActions();

			items = petPage.getItems();
			lastPage = petPage.getLastPage();
			page = petPage.getPage();
			pageSize = petPage.getPageSize();
			totalCount = petPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Pet> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(PetResource petResource)
		throws Exception {

		petResource.setContextAcceptLanguage(_acceptLanguage);
		petResource.setContextCompany(_company);
		petResource.setContextHttpServletRequest(_httpServletRequest);
		petResource.setContextHttpServletResponse(_httpServletResponse);
		petResource.setContextUriInfo(_uriInfo);
		petResource.setContextUser(_user);
		petResource.setGroupLocalService(_groupLocalService);
		petResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<PetResource>
		_petResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}