package com.poc.employee.portlet;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ParamUtil;
import com.poc.employee.constants.EmployeePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.*;

import com.poc.employee.model.EmployeeEntry;

import com.poc.employee.service.EmployeeEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author phidx
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EmployeePortletKeys.Employee,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EmployeePortlet extends MVCPortlet {

	@Reference
	EmployeeEntryLocalService employeeEntryLocalService;

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		List<EmployeeEntry> studentList = employeeEntryLocalService.getStudents(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("studentList", studentList);

		super.render(renderRequest, renderResponse);
	}

	@ProcessAction(name = "addStudent")
	public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse) {
		String name = ParamUtil.getString(actionRequest, "name");
		Date birthDay = ParamUtil.getDate(actionRequest, "birthDay", new SimpleDateFormat("yyyy/DD/mm") {
		});
		String gender = ParamUtil.getString(actionRequest, "gender");
		String address = ParamUtil.getString(actionRequest, "address");
		String hasAccount = ParamUtil.getString(actionRequest, "hasAccount");

		System.out.println(" name " + name);
		System.out.println(" bi " + birthDay);
		System.out.println(" ge " + gender);
		System.out.println(" ad " + address);
		System.out.println(" ha " + hasAccount);

		EmployeeEntry employeeEntry = new EmployeeEntry() {
			@Override
			public void persist() {

			}

			@Override
			public String getPrimaryKey() {
				return null;
			}

			@Override
			public void setPrimaryKey(String primaryKey) {

			}

			@Override
			public String getUuid() {
				return null;
			}

			@Override
			public void setUuid(String uuid) {

			}

			@Override
			public String getEmployeeId() {
				return null;
			}

			@Override
			public void setEmployeeId(String employeeId) {

			}

			@Override
			public long getGroupId() {
				return 0;
			}

			@Override
			public void setGroupId(long groupId) {

			}

			@Override
			public long getCompanyId() {
				return 0;
			}

			@Override
			public void setCompanyId(long companyId) {

			}

			@Override
			public long getUserId() {
				return 0;
			}

			@Override
			public void setUserId(long userId) {

			}

			@Override
			public String getUserUuid() {
				return null;
			}

			@Override
			public void setUserUuid(String userUuid) {

			}

			@Override
			public String getUserName() {
				return null;
			}

			@Override
			public void setUserName(String userName) {

			}

			@Override
			public Date getCreateDate() {
				return null;
			}

			@Override
			public void setCreateDate(Date createDate) {

			}

			@Override
			public Date getModifiedDate() {
				return null;
			}

			@Override
			public void setModifiedDate(Date modifiedDate) {

			}

			@Override
			public String getName() {
				return null;
			}

			@Override
			public void setName(String name) {

			}

			@Override
			public Date getBirthDay() {
				return null;
			}

			@Override
			public void setBirthDay(Date birthDay) {

			}

			@Override
			public int getGender() {
				return 0;
			}

			@Override
			public void setGender(int gender) {

			}

			@Override
			public String getAddress() {
				return null;
			}

			@Override
			public void setAddress(String address) {

			}

			@Override
			public boolean getHasAccount() {
				return false;
			}

			@Override
			public boolean isHasAccount() {
				return false;
			}

			@Override
			public void setHasAccount(boolean hasAccount) {

			}

			@Override
			public ExpandoBridge getExpandoBridge() {
				return null;
			}

			@Override
			public Map<String, Object> getModelAttributes() {
				return null;
			}

			@Override
			public Serializable getPrimaryKeyObj() {
				return null;
			}

			@Override
			public boolean isCachedModel() {
				return false;
			}

			@Override
			public boolean isEntityCacheEnabled() {
				return false;
			}

			@Override
			public boolean isEscapedModel() {
				return false;
			}

			@Override
			public boolean isFinderCacheEnabled() {
				return false;
			}

			@Override
			public boolean isNew() {
				return false;
			}

			@Override
			public void resetOriginalValues() {

			}

			@Override
			public void setCachedModel(boolean cachedModel) {

			}

			@Override
			public void setExpandoBridgeAttributes(BaseModel<?> baseModel) {

			}

			@Override
			public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {

			}

			@Override
			public void setExpandoBridgeAttributes(ServiceContext serviceContext) {

			}

			@Override
			public void setModelAttributes(Map<String, Object> attributes) {

			}

			@Override
			public void setNew(boolean n) {

			}

			@Override
			public void setPrimaryKeyObj(Serializable primaryKeyObj) {

			}

			@Override
			public CacheModel<EmployeeEntry> toCacheModel() {
				return null;
			}

			@Override
			public EmployeeEntry toEscapedModel() {
				return null;
			}

			@Override
			public EmployeeEntry toUnescapedModel() {
				return null;
			}

			@Override
			public String toXmlString() {
				return null;
			}

			@Override
			public StagedModelType getStagedModelType() {
				return null;
			}

			@Override
			public Class<?> getModelClass() {
				return null;
			}

			@Override
			public String getModelClassName() {
				return null;
			}

			@Override
			public int compareTo(EmployeeEntry o) {
				return 0;
			}

			@Override
			public Object clone() {
				return null;
			}
		};

		employeeEntry.setEmployeeId(UUID.randomUUID().toString());
		employeeEntry.setName( ParamUtil.getString(actionRequest, "name"));
		employeeEntry.setBirthDay(birthDay);
		employeeEntry.setGender(gender.equals("male") ? 0 : 1 );
		employeeEntry.setHasAccount(Objects.nonNull(hasAccount) ? true : false);

		System.out.println("---"+
				employeeEntry.getEmployeeId()+" "+
				employeeEntry.getCompanyId()+" "+
				employeeEntry.getName() +" "+
				employeeEntry.getAddress()+" "+
				employeeEntry.getBirthDay()+" "+
				employeeEntry.getHasAccount()+" "+
				employeeEntry.getGender()

		);

		String employeeId = UUID.randomUUID().toString();
	employeeEntryLocalService.createEmployeeEntry(employeeId);
	employeeEntry.setEmployeeId(employeeId);
	//employeeEntryLocalService.addEmployeeEntry(employeeEntry);

	}



}