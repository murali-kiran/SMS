<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
	$(document).ready(document.f.j_username.focus);
</script>

<table cellpadding="0" cellspacing="0" border="0"  style="width: 960px; margin-left: auto; margin-right: auto;">
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
			<form name='f' action="${pageContext.servletContext.contextPath}/forgotpass/submit" method='POST'>
				<div style="width: 100%; padding-top: 20px;">
					<div class="menu-title">
						<span style="color: #fff; font-weight: bold; font-size: 13px;">Forget Password</span>
						<span style="color: #fff; float: right;">or <a class="link-login" href="${pageContext.servletContext.contextPath}/login">Sign in</a></span>
					</div>
					<div class="menu-content" style="padding: 10px;">
						<div style="margin-top: 10px;">Email</div>
						<div style="margin-top: 5px;"><input type='text' name='email' value='' style="width: 280px; height: 2em;" /></div>
						<div style="margin-top: 10px;" class="success">${success}</div>
						<div style="margin-top: 10px;" class="error">${error}</div>
						<div style=" margin-top: 30px;">
							<span><input name="submit" type="submit" value="Continue" /></span>
						</div>
					</div>
				</div>
			</form> 
		</td>
	</tr>
</table>