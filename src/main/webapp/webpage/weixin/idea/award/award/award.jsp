<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>奖品记录</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body style="overflow-y: hidden" scroll="no">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="awardController.do?addOrUpdate">
            <input id="id" name="id" type="hidden" value="${awardPage.id}">
            <table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
                <tr>
                    <td align="right">
                        <label class="Validform_label">
                            奖品名称:
                        </label>
                    </td>
                    <td class="value">
                        <input class="inputxt" id="name" name="name" ignore="ignore"
                               value="${awardPage.name}">
                        <span class="Validform_checktip"></span>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="Validform_label">
                            奖品数量:
                        </label>
                    </td>
                    <td class="value">
                        <input class="inputxt" id="number" name="number" ignore="ignore"
                               value="${awardPage.number}">
                        <span class="Validform_checktip"></span>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="Validform_label">
                            价格:
                        </label>
                    </td>
                    <td class="value">
                        <input class="inputxt" id="price" name="price" ignore="ignore"
                               value="${awardPage.price}">
                        <span class="Validform_checktip"></span>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="Validform_label">
                            奖品等级:
                        </label>
                    </td>
                    <td class="value">
                        <input class="inputxt" id="level" name="level" ignore="ignore"
                                 value="${awardPage.level}">
                        <span class="Validform_checktip"></span>
                    </td>
                </tr>
                <tr>
                    <td align="right">
                        <label class="Validform_label">
                            奖品描述:
                        </label>
                    </td>
                    <td class="value">
                        <input class="inputxt" id="description" name="description" ignore="ignore"
                               value="${awardPage.description}">
                        <span class="Validform_checktip"></span>
                    </td>
                </tr>
            </table>
        </t:formvalid>
 </body>