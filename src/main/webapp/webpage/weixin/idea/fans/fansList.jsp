<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<t:datagrid name="fansList" actionUrl="fansController.do?datagrid" fit="true" fitColumns="true" idField="id" queryMode="group">
    <t:dgCol title="编号" field="id" hidden="false" ></t:dgCol>
    <t:dgCol title="关注状态" field="subscribe" query="true" width="100"></t:dgCol>
    <t:dgCol title="昵称" field="nickname" query="true" width="100"></t:dgCol>
    <t:dgCol title="性别" field="sex" width="100"></t:dgCol>
    <t:dgCol title="城市" field="city" width="100"></t:dgCol>
    <t:dgCol title="省份" field="province" width="100"></t:dgCol>
    <t:dgCol title="国家" field="country" width="100"></t:dgCol>
    <t:dgCol title="头像" field="headimgurl" width="100"></t:dgCol>
    <t:dgCol title="关注时间" field="subscribetime" width="100"></t:dgCol>
    <t:dgCol title="服务号微信" field="accountid" width="100"></t:dgCol>
</t:datagrid>