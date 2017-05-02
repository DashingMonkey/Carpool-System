<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>学生界面</title>
<link href="CSS/bootstrap.min.css" rel="stylesheet">
<link href="CSS/templatemo-style.css" rel="stylesheet">
</head>
<body>
	<!-- Left column -->
	<div class="templatemo-flex-row">
		<div class="templatemo-sidebar">
			<header class="templatemo-site-header">
			<h1>学生窗口</h1>
			</header>
			<div class="profile-photo-container">
				<img src="Image/school.png" alt="School Photo"
					class="img-responsive">
				<div class="profile-photo-overlay"></div>
			</div>
			<nav class="templatemo-left-nav">
			<ul>
				<li><a href="noticeservlet?opttype=GqueryLatest" class="active">查看公告</a></li>
				<li><a href="graduateservlet?opttype=showGchose">选择导师</a></li>
				<li><a href="tutorservlet?opttype=Gquery">查看导师</a></li>
				<li><a href="home.jsp">退出登录</a></li>
			</ul>
			</nav>
		</div>
		<!-- Main content -->
		<div class="templatemo-content col-1 light-gray-bg">
			<div class="templatemo-top-nav-container">
				<div class="row">
					<nav class="templatemo-top-nav col-lg-12 col-md-12">
					<ul class="text-uppercase">
						<li class="user">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎你，<%=session.getAttribute("UserName")%>
						<li><a href="GManage_Changepwd.jsp">修改密码 </a></li>
						<li><a href="GShowInfo.jsp">我的信息</a></li>
					</ul>
					</nav>
				</div>
			</div>
			<div class="templatemo-content-container">
				<div class="templatemo-flex-row flex-content-row">
					<div class="col-1">
						<div
							class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
							<div class="panel-heading templatemo-position-relative">
								<h2 class="text-uppercase">公告</h2>
							</div>
							<div class="table-responsive">
								<h1>&nbsp;</h1>
								<ul class="text-downercase">
									<c:forEach items="${nlist}" var="no">
										<li class="title"><h1>${no.title }</h1></li>
										<li class="time"><h4>
												<fmt:formatDate type="both" value="${no.time}" />
											</h4></li>
										<li class="content"><h2>${no.content }</h2></li>
									</c:forEach>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- Second row ends -->
				<div class="templatemo-flex-row flex-content-row">
					<div class="col-1">
						<div
							class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
							<div class="panel-heading templatemo-position-relative">
								<h2 class="text-uppercase">注意事项</h2>
							</div>
							<div class="table-responsive">
								<ul class="text-downercase2">
									<h2>2016～2017学年第一学期研究生学习注意事项（研究生）</h2>
									<h4>
										全体研究生：
										8月28日研究生老生报到注册。电气学院2016级研究生新生8月30日报到；其他学院的2016级研究生9月2日报到。关于2016～2017学年第一学期研究生学习事宜，注意事项如下：
										<h4>一、2015级全体研究生：</h4>
										<h4>
											根据我校2015级硕士研究生各专业《培养方案》，以及2015级全体研究生的《个人培养计划》，现将本届研究生课程学习阶段综合考核及学位论文开题报告的阶段性工作通知如下：</h4>
										<h4>1、课程学习阶段综合考核
											（1）严格遵守考试（考核）规则和纪律，充分重视本学期各项考试（考核，包括必修环节），全面完成第一学年研究生课程学习基本任务，请2015级全体研究生登录研究生信息管理系统，查看各自的课程考试（考核）成绩；
											（2）2015级全体研究生应在第三学期（2016～2017学年第一学期）第1～2两周内，填写《上海电力学院硕士研究生课程学习阶段综合考核表》（可在研究生处网页→文件下载→教学与培养栏目下载参考），完成课程学习阶段综合考核工作，简要安排如下：
											8月29～8月31日，2015级全体研究生，下载《上海电力学院硕士研究生课程学习阶段综合考核表》，如实填写完整（封面、个人总结、统一发放的审核后的成绩单、业务学习总结），以班委集体交辅导员老师。
											9月1～4日，辅导员鉴定意见。 9月5～9日，院系学科点进行综合考核评定。
											9月13日，汇总公布课程学习阶段综合考核评定结果：优秀、良好、合格、警告、不合格。</h4>
										<h4>2、学位论文选题及开题报告 （1）时间安排：9月14日～10月14日，由各学科硕士点组织实施。
											（2）主要流程：下载硕士研究生学位论文开题文件(2015年)，逐项完成以下任务。 ①
											按《上海电力学院关于硕士学位论文开题报告的规定》的基本要求，组织实施； ②
											研究生本人填写《上海电力学院研究生学位论文开题报告》； ③ 按“2015级研究生开题流程一览（学生版）”，按流程逐项完成；</h4>
										<h4>二、2016级全体研究生新生：
											2016～2017学年第一学期研究生课程南通校区从2016年9月5日（校历第2周周一）正式开始上课，杨浦校区从2016年9月7日（校历第2周周三）正式开始上课，请2015级全体研究生新生准时参加课程学习。并请注意以下事项：</h4>
										<h4>1、研究生课表。研究生应根据个人培养计划，对照学期课表（详见，登录研究生信息管理系统查阅），主动全程参加研究生课程的听课学习，按时独立完成任课教师布置的各项课程作业和其他任务。</h4>
										<h4>2、课程增退改。研究生课程增退改处理；具体流程为：填写一式三份的《研究生退、增、改选课程申请表》，并另附上详细的情况说明，请导师确认签字，一并交硕士点所在二级院部研究生工作秘书审核；截止时间2016年9月21日，逾期不予受理。</h4>
										<h4>3、考勤。严格执行研究生请假制度，旷课超过三分之一者，将被取消考试资格；</h4>
										<h4>4、课程考试。遵守学校课程考核相关规章制度，对于采用笔试考试科目，应严守考场纪律，杜绝任何形式的考场违纪和作弊行为；对于非笔试考查科目，应独立完成任课教师布置的考核题目，按时保质提交考核材料；</h4>
										<h4>5、必修环节。在导师指导下，逐步开展教学（生产）实践、学术活动、文献阅读等研究生培养必修环节，及时登录研究生信息管理系统，填注内容，早日形成考核结果，综合提升研究生培养质量和水平。</h4>
										<h4>6、培养计划及最低学分。参加研究生课程阶段学习的所有课程、必修环节的考核，取得成绩和学分，准备迎接硕士研究生课程学习综合考核，为进入学位论文阶段奠定坚实的基础。</h4>

										<h4>特此通知。</h4>
								</ul>
							</div>
						</div>
					</div>
				</div>

			</div>
			<footer class="text-right">
			<p>大作业-研究生导师双选系统-by许继中</p>
			</footer>
		</div>
	</div>
</body>
</html>