<%@page pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" /> 
        <script language="javascript" type="text/javascript" src="../js/jquery-1.4.3.js"></script>
        <script language="javascript" type="text/javascript">
            //暂停
            function pause_account(id) {
            	//询问用户是否真正暂停
            	var b = window.confirm("确定要暂停此账务账号吗？");
            	if(!b) {
            		//如果取消则不执行暂停
            		return;
            	}
            	//发送异步请求，来暂停数据
            	$.post(
            		"pauseAccount",
            		{"id":id},
            		function(data) {
            			var info = data;
            			//修改提示信息
            			$("#operate_result_msg").text(info.message);
            			//显示提示信息
            			$("#operate_result_info").show();
            			//刷新页面
            			setTimeout(function(){
            				//推迟刷新
	            			var page = $("#curr_page").val();
	            			to_page(page);
            			}, 2000);
            		}
            	);
            }
            //提交分页查询请求
            function to_page(page) {
            	//给表单中隐藏框（当前页）赋值
            	document.getElementById("curr_page").value=page;
            	//提交表单
            	document.forms[0].submit();
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="../images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">                        
            <ul id="menu">
                <li><a href="../index.html" class="index_off"></a></li>
                <li><a href="../role/role_list.html" class="role_off"></a></li>
                <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
                <li><a href="../fee/fee_list.html" class="fee_off"></a></li>
                <li><a href="../account/account_list.html" class="account_on"></a></li>
                <li><a href="../service/service_list.html" class="service_off"></a></li>
                <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="../report/report_list.html" class="report_off"></a></li>
                <li><a href="../user/user_info.html" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </ul>            
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
        	<!-- 
        		使用表单提交的方式，将搜索条件
        		提交给查询Action，可以避免拼参数
        		条件。
        	 -->
            <form action="findAccount" method="post">
                <!--查询-->
                <div class="search_add">   
                	<!-- 
                		1.通过提交表单的方式，来提交分页
                		查询的请求，以简化分页请求。
                		分页请求不仅要包含当前页的条件，
                		也要包含搜索条件，所以在表单中
                		追加当前页条件，提交表单即可。
                		2.将hidden改成UI标签，目的是让框
                		中回显出默认值，我们在脚本中可以
                		从这个框中取出默认值，即当前页。
                	 -->
                    <s:hidden name="page" id="curr_page"/>
                    <div>
                    身份证：
                    	<s:textfield name="idcardNo" cssClass="text_search"/>
                    </div>                            
                    <div>
                    姓名：
                    	<s:textfield name="realName" cssClass="width70 text_search"/>
                    </div>
                    <div>
                    登录名：
                    	<s:textfield name="loginName" cssClass="text_search"/>
                    </div>
                    <div>
                    状态：
                    	<s:select name="status" list="#{'0':'开通','1':'暂停','2':'删除'}" headerKey="" headerValue="全部" cssClass="select_search"/>
                    </div>
                    <div><input type="button" value="搜索" class="btn_search" onclick="to_page(1);"/></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='account_add.html';" />
                </div>  
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                 	<span id="operate_result_msg">删除成功，且已删除其下属的业务账号！</span>
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th>账号ID</th>
                        <th>姓名</th>
                        <th class="width150">身份证</th>
                        <th>登录名</th>
                        <th>状态</th>
                        <th class="width100">创建日期</th>
                        <th class="width150">上次登录时间</th>                                                        
                        <th class="width200"></th>
                    </tr>
              		<s:iterator value="accounts">     
	                    <tr>
	                        <td><s:property value="id"/></td>
	                        <td><a href="account_detail.html"><s:property value="realName"/></a></td>
	                        <td><s:property value="idcardNo"/></td>
	                        <td><s:property value="loginName"/></td>
	                        <td>
	                        	<s:if test="status==0">开通</s:if>
	                        	<s:elseif test="status==1">暂停</s:elseif>
	                        	<s:else>删除</s:else>
	                        </td>
	                        <td><s:date name="createDate" format="yyyy-MM-dd"/></td>
	                        <td><s:date name="lastLoginTime" format="yyyy-MM-dd hh:mm:ss"/></td>                            
	                        <td class="td_modi">
	                        	<s:if test="status==0">
		                            <input type="button" value="暂停" class="btn_pause" onclick="pause_account(<s:property value="id"/>);" />
		                            <input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />
		                            <input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />
	                        	</s:if>
	                        	<s:elseif test="status==1">
	                        		<input type="button" value="开通" class="btn_start" onclick="setState();" />
		                            <input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />
		                            <input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />
	                        	</s:elseif>
	                        	<s:else>
	                        	</s:else>
	                        </td>
	                    </tr>
                    </s:iterator>         
                </table>
                <p>业务说明：<br />
                1、创建则开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、暂停账务账号，同时暂停下属的所有业务账号；<br />                
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
                7、删除账务账号，同时删除下属的所有业务账号。</p>
                </div>                   
                <!--分页-->
                <div id="pages">
                    <a href="javascript:to_page(1);">首页</a>
                    <s:if test="page==1">
                    	<a href="#">上一页</a>
                    </s:if>
        	        <s:else>
        	        	<a href="javascript:to_page(<s:property value="page-1"/>);">上一页</a>
        	        </s:else>
                    
                    <s:iterator begin="1" end="totalPage" var="k">
                    	<s:if test="#k==page">
                    		<a href="javascript:to_page(<s:property value="#k"/>);" class="current_page"><s:property value="#k"/></a>
                    	</s:if>
                    	<s:else>
                    		<a href="javascript:to_page(<s:property value="#k"/>);"><s:property value="#k"/></a>
                    	</s:else>
                    </s:iterator>
                    
                    <s:if test="page==totalPage">
                    	<a href="#">下一页</a>
                    </s:if>
                    <s:else>
                    	<a href="javascript:to_page(<s:property value="page+1"/>);">下一页</a>
                    </s:else>
                    <a href="javascript:to_page(<s:property value="totalPage"/>);">末页</a>
                </div>                    
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)加拿大达内IT培训集团公司 </p>
        </div>
    </body>
</html>