<%@page pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="../styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //排序按钮的点击事件
            function sort(btnObj) {
                if (btnObj.className == "sort_desc")
                    btnObj.className = "sort_asc";
                else
                    btnObj.className = "sort_desc";
            }

            //启用
            function startFee() {
                var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //删除
            function deleteCost(id) {
            	var r = window.confirm("是否要删除选中数据？");
            	if(r) {
            		//如果用户确定要删除
            		window.location.href = "deleteCost?id="+id;
            	}
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
                <li><a href="../fee/fee_list.html" class="fee_on"></a></li>
                <li><a href="../account/account_list.html" class="account_off"></a></li>
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
            <form action="" method="">
                <!--排序-->
                <div class="search_add">
                    <div>
                        <!--<input type="button" value="月租" class="sort_asc" onclick="sort(this);" />-->
                        <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='toAddCost';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>    
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr> 
                        <s:iterator value="costs">                     
	                        <tr>
	                            <td><s:property value="id"/></td>
	                            <td><a href="fee_detail.html"><s:property value="name"/></a></td>
	                            <td><s:property value="baseDuration"/></td>
	                            <td><s:property value="baseCost"/></td>
	                            <td><s:property value="unitCost"/></td>
	                            <td>
	                            	<!-- 
	                            		日期标签：
	                            		通过name中的OGNL表达式取值，
	                            		并将结果按照format中的格式进行
	                            		格式化，然后输出在标签位置。
	                            	 -->
	                            	<s:date name="createTime" format="yyyy-MM-dd"/>
	                            </td>
	                            <td>
	                            	<s:date name="startTime" format="yyyy-MM-dd"/>
	                            </td>
	                            <td>
	                            	<s:if test="status==0">开通</s:if>
	                            	<s:else>暂停</s:else>
	                            </td>
	                            <td>                                
	                                <input type="button" value="启用" class="btn_start" onclick="startFee();" />
	                                <input type="button" value="修改" class="btn_modify" onclick="location.href='toUpdateCost?id=<s:property value="id"/>';" />
	                                <input type="button" value="删除" class="btn_delete" onclick="deleteCost(<s:property value="id"/>);" />
	                            </td>
	                        </tr>
                        </s:iterator>
                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
                </div>
                <!--分页-->
                <div id="pages">
                	<!-- 如果是第一页，不能点上一页 -->
                	<s:if test="page==1">
                		<a href="#">上一页</a>
                	</s:if>
                	<s:else>
                		<a href="findCost?page=<s:property value="page-1"/>">上一页</a>
                	</s:else>
        	        
        	        <!-- 
        	        	1.从1循环到总页数。
        	        	2.根据循环变量与当前页比较，判断
        	        		是否位于当前页。
        	        	3.可以按照相对路径来写连接的URL，
        	        		具体的是相对于当前浏览器地址栏
        	        		中的URL的namespace。
        	        		即，当地址栏中的namespace与href
        	        		中地址的namespace一样，则可以将
        	        		href中的namespace以及之前的部分
        	        		省略，那么在访问该URL时，浏览器
        	        		会自动将当前地址栏中的namespace
        	        		追加到访问地址的前面。
        	         -->
        	         <s:iterator begin="1" end="totalPage" var="k">
        	         	<s:if test="#k==page">
        	         		<a href="findCost?page=<s:property value="#k"/>" class="current_page"><s:property value="#k"/></a>
        	         	</s:if>
        	         	<s:else>
        	         		<a href="findCost?page=<s:property value="#k"/>"><s:property value="#k"/></a>
        	         	</s:else>
        	         </s:iterator>
                    
                    <!-- 如果当前页是最后一页，
                    	不能点下一页 -->
                    <s:if test="page==totalPage">
                    	<a href="#">下一页</a>
                    </s:if>
                    <s:else>
                    	<a href="findCost?page=<s:property value="page+1"/>">下一页</a>
                    </s:else>
                    
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