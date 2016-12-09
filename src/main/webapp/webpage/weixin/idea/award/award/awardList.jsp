<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="awardList" title="奖品记录" actionUrl="awardController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="奖品编号" field="id" hidden="false"></t:dgCol>
   <t:dgCol title="奖品名称" field="name" width="100"></t:dgCol>
   <t:dgCol title="奖品数量" field="number" width="100"></t:dgCol>
   <t:dgCol title="奖品价格" field="price" width="100"></t:dgCol>
   <t:dgCol title="奖品等级" field="level" width="100"></t:dgCol>
   <t:dgCol title="奖品描述" field="description" width="100"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="120"></t:dgCol>
   <t:dgDelOpt title="删除" url="awardController.do?del&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="awardController.do?addOrUpdate" funname="add"  height="500"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="awardController.do?addOrUpdate" funname="update" height="500"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="awardController.do?addOrUpdate" funname="detail" height="500"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>