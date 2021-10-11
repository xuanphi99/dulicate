package com.dogoo.poc.pet.rest.internal.graphql.servlet.v1_0;

import com.dogoo.poc.pet.rest.internal.graphql.mutation.v1_0.Mutation;
import com.dogoo.poc.pet.rest.internal.graphql.query.v1_0.Query;
import com.dogoo.poc.pet.rest.resource.v1_0.PetResource;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author khoavu
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setPetResourceComponentServiceObjects(
			_petResourceComponentServiceObjects);

		Query.setPetResourceComponentServiceObjects(
			_petResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/dogoo/pet-rest-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<PetResource>
		_petResourceComponentServiceObjects;

}