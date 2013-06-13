<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script type="text/javascript">
	$(function() {
		$("#numEmp").spinner(
			{
				"value":"5",
				"min":1,
				"change": function( event, ui ) {
					onClick();
				}, 
				"stop": function( event, ui ) {
					onClick();
				}
			}
		);
		onClick();
	});
	
	var pricingSlabs = ${pricingSlabs};
	function onClick(){
		var intRegex = /^\d+$/;
		
		var numEmp = $("#numEmp").val();
		var rate = 0;
		var price = 0;
		
		if(intRegex.test(numEmp)){
			for(var i = 0; i < pricingSlabs.length; i++){
				if(pricingSlabs[i][0] > numEmp){
					continue;
				} else {
					rate = pricingSlabs[i][2];
				}
			}
			
			price = rate * numEmp;
		} else {
			price = 0;
		}
		
		$("#price").text(Math.round(price) + ".00"); 
	}
	
	function onSubmit(){
		$('form input:submit').attr('disabled', "true");
	}
	
</script>

<table cellpadding="0" cellspacing="0" border="0"  style="width: 960px; margin-left: auto; margin-right: auto;" onsubmit="onSubmit()">
	<tr>
		<td style="width: 660px; padding: 15px; padding-left: 0px; border: 0px; vertical-align: top;">
			<table cellpadding="0" cellspacing="0" border="0" style="width: 100%; height: 100%; padding: 5px;">
				<tr style="height: 70px;">
					<td colspan="2">
						<img alt="Effort" src="${pageContext.servletContext.contextPath}/resources/img/effort.png">
					</td>
				</tr>
				<tr style="height: 20px;"><td></td></tr>
				<tr style="height: 80px;">
					<td style="width: 60px;" valign="middle">
						<img src="${pageContext.servletContext.contextPath}/resources/img/do_more_with_less.png" align="left" style="padding-left: 10px;"/>
					</td>
					<td valign="middle">
						<div style="font-size: 15px; font-weight: bold; color: #787878;">Do more with less</div>
						<div style="color: #787878;">Track your field force to maximize their effectiveness and efficiency.</div>
					</td>
				</tr>
				<tr style="height: 80px;">
					<td style="width: 60px;" valign="middle">
						<img src="${pageContext.servletContext.contextPath}/resources/img/guarantee_service.png" align="left" style="padding-left: 10px;"/>
					</td>
					<td valign="middle">
						<div style="font-size: 15px; font-weight: bold; color: #787878;">Guarantee service</div>
						<div style="color: #787878;">Guarantee service delivery to customers with audio, video, and image proofs.</div>
					</td>
				</tr>
				<tr style="height: 80px;">
					<td style="width: 60px;" valign="middle">
						<img src="${pageContext.servletContext.contextPath}/resources/img/make_right_decisions_quicker.png" align="left" style="padding-left: 10px;"/>
					</td>
					<td valign="middle">
						<div style="font-size: 15px; font-weight: bold; color: #787878;">Make right decisions quicker</div>
						<div style="color: #787878;">Enable seamless exchange of information among your field force and in-office employees.</div>
					</td>
				</tr>
				<tr style="height: 100%;"><td></td></tr>
			</table>
		</td>
		<td style="width: 300px; padding: 15px; padding-right: 0px; border: 0px; vertical-align: top;">
			<form:form method="post" action="${pageContext.servletContext.contextPath}/signup/submit" commandName="signup" modelAttribute="signup">
				<div style="width: 100%; padding-top: 20px;">
					<div class="menu-title">
						<span style="color: #fff; font-weight: bold; font-size: 13px;">Create an Account</span>
						<span style="color: #fff; float: right;">or <a class="link-login" href="${pageContext.servletContext.contextPath}/login">Sign in</a></span>
					</div>
					<div class="menu-content" style="padding: 10px;">
						<div style="margin-top: 10px;"><form:label path="primaryContactFirstName">First Name</form:label></div>
						<div style="margin-top: 5px;"><form:input path="primaryContactFirstName" style="width: 280px; height: 2em;" /></div>
						<div style="margin-top: 5px;"><form:errors path="primaryContactFirstName" cssClass="error" /></div>
						
						<div style="margin-top: 10px;"><form:label path="primaryContactLastName">Last Name</form:label></div>
						<div style="margin-top: 5px;"><form:input path="primaryContactLastName" style="width: 280px; height: 2em;" /></div>
						<div style="margin-top: 5px;"><form:errors path="primaryContactLastName" cssClass="error" /></div>
						
						<div style="margin-top: 10px;"><form:label path="primaryContactPhone">Phone</form:label></div>
						<div>
							<div style="padding-top: 5px;"><form:input path="primaryContactPhone" style="width: 280px; height: 2em;" maxlength="12"/></div>
							<div style="color: gray;">12-digit mobile number</div>
							<div style="padding-bottom: 5px; color: gray;">e.g. 919000464327</div>
						</div>
						<div style="margin-top: 5px;"><form:errors path="primaryContactPhone" cssClass="error" /></div>
						
						<div style="margin-top: 10px;"><form:label path="primaryContactEmail">Email</form:label></div>
						<div style="margin-top: 5px;"><form:input path="primaryContactEmail" style="width: 280px; height: 2em;" /></div>
						<div style="margin-top: 5px;"><form:errors path="primaryContactEmail" cssClass="error" /></div>
						
						<div style="margin-top: 10px;"><form:label path="companyName">Company Name</form:label></div>
						<div style="margin-top: 5px;"><form:input path="companyName" style="width: 280px; height: 2em;" /></div>
						<div style="margin-top: 5px;"><form:errors path="companyName" cssClass="error" /></div>
						
					<%-- 	<div style="margin-top: 10px;"><form:label path="numEmp">Number of employees</form:label></div>
						<div style="margin-top: 5px;"><form:input path="numEmp" value="5" id="numEmp" style="width: 100px; height: 2em;" /></div>
						<div style="margin-top: 5px;"><form:errors path="numEmp" cssClass="error" /></div>
						
						<div style="margin-top: 10px;">
							<span style="padding-top: 5px; padding-bottom: 5px;">Price: <b>INR </b><span id="price" style="font-weight: bold;">0.00</span></span>
							<span style="float: right;"><form:checkbox path="trial" checked="checked" />&nbsp;<form:label path="trial">Free trial for ${trial} days</form:label></span></div>
						<div style="margin-top: 5px; float: right;"><form:errors path="trial" cssClass="error" /></div>
						 --%>
						<div style="margin-top: 10px;"><form:label path="password">Password</form:label></div>
						<div style="margin-top: 5px;"><form:password path="password" style="width: 280px; height: 2em;"  /></div>
						<div style="margin-top: 5px;"><form:errors path="password" cssClass="error" /></div>
						
						<div style="margin-top: 10px;"><form:label path="repassword">Confirm password</form:label></div>
						<div style="margin-top: 5px;"><form:password path="repassword" style="width: 280px; height: 2em;"  /></div>
						<div style="margin-top: 5px;"><form:errors path="repassword" cssClass="error" /></div>
						
						<c:if test="${not empty error}"><div class="errorblock" style="color: red;">${error}</div></c:if>
						<div style=" margin-top: 30px;">
							<span><input id="submit" name="submit" type="submit" value="Sign Up" /></span>
						</div>
					</div>
				</div>
			</form:form>
		</td>
	</tr>
</table>


