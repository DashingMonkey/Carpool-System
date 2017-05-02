<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>教师界面</title>
<link href="CSS/bootstrap.min.css" rel="stylesheet">
<link href="CSS/templatemo-style.css" rel="stylesheet">
</head>
<body>
	<!-- Left column -->
	<div class="templatemo-flex-row">
		<div class="templatemo-sidebar">
			<header class="templatemo-site-header">
			<h1>教师窗口</h1>
			</header>
			<div class="profile-photo-container">
				<img src="Image/school.png" alt="School Photo"
					class="img-responsive">
				<div class="profile-photo-overlay"></div>
			</div>
			<nav class="templatemo-left-nav">
			<ul>
				<li><a href="noticeservlet?opttype=TqueryLatest" class="active">查看公告</a></li>
				<li><a href="tutorservlet?opttype=showTchose">选择学生</a></li>
				<li><a href="graduateservlet?opttype=Tquery">查看学生</a></li>
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
						<li><a href="TManage_Changepwd.jsp">修改密码 </a></li>
						<li><a href="TShowInfo.jsp">我的信息</a></li>
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
									<h2>2016～2017学年第一学期研究生课程教学注意事项（教师）</h2>
									<h4>各二级院部研究生教育领导、管理人员、全体研究生课程任课教师：</h4>
									<h4>2016～2017学年第一学期研究生新生课程南通校区从2016年9月5日（校历第2周周一）正式开始上课，杨浦校区从2016年9月7日（校历第2周周三）正式开始上课，请各二级院部研究生教育管理人员及时通知全体研究生课程任课教师、研究生准时开展课程教学工作。并请注意以下事项：</h4>
									<h4>
										1、各二级院部研究生教育管理领导、研究生工作秘书（教务员）：
										<h4>
											（1）全方位开展研究生课程教学各项工作
											①根据已排定的研究生课程的师资配备、课程表，在开学初通知到位，并对教学秩序状况进行检查，防止发生教师不到位等教学事故；
											②开学两周内，收齐并汇总所开课程的教学进度表（含课程考核形式），按要求签署完毕，送研究生处培养办备案，并适时检查课程教学进度具体实施情况；
											④开学四周内检查并形成本学期的各课程教学编班名单；
											⑤严禁私自调课严格执行研究生课程调课制度和流程，以建立良好的教学秩序，努力提升教学质量；
											⑥加强日常教学监督工作，开展研究生课程期中教学检查工作。
											<h4>（2）全面完善使用研究生信息管理系统
												①各二级院部研究生教育领导、管理工作人员应熟悉和使用该系统的基本功能，并对网上递交的相关材料进行审核；
												②任课教师应在系统中完善个人信息，通过系统完成教务的相关环节，如课程安排、选课学生名单、考核成绩录入等；
												③导师应在系统中完善个人信息，熟知所指导的研究生的基本培养状况，并在网上对学生递交各项材料进行审核；
												④研究生应在系统中填注完成整个培养环节，如课程环节的个人培养计划、选课，学位论文环节的开题、中期检查等工作，并及时填写提交其他培养环节，如公开发表学术论文、参加学术活动讲座等各类材料。</h4>
											<h4>2、研究生课程任课教师</h4>
											<h4>（1）全面开展本学期研究生课程授课工作
												①课表。请参阅研究生处网页教学培养栏目的本学期研究生课表，也可登陆个人的研究生信息管理系统查阅；
												②教学进度表。请在研究生处网页下载填写完整（含课程考核形式），开学两周内交二级院部研究生工作秘书汇总；
												③研究生课程教学手册。到所在二级院部领取并填写研究生课程教学手册，加强课程教学日常情况记录。
												④教师调课。为规范研究生课程教学秩序，请至少提前一周，下载填写研究生课程教师调课申请单，由院系研究生教育负责领导签字，研究生核实备案；
												⑤日常考勤。任课教师在日常考勤中若发现无故旷课超过三分之一的情况，请填写《上海电力学院研究生课程无考试资格学生统计表》并及时通知院系，报研究生处统一处理，取消所涉研究生的考试资格；
												⑥教材。按《研究生课程教学大纲》统计的教材及参考书目，研究生处已委托教材科完成本学期研究生课程的教材采购。请任课教师组织本教学班学生前往教材科集体购买学生用书；教师用书请到各二级院部办公室按相应流程操作；
												⑦其他说明。若任课教师对教室中的多媒体软硬件、机房等的使用，有特殊要求，请提前两周，通过二级院部汇总，告知研究生处。
												⑧教育督导。研究生处将逐步建立健全研究生教育督导机制，加强研究生教育中课程、学位论文开题、中期检查、学位论文答辩等各个环节的监督。</h4>
											<h4>（2）全面使用研究生信息管理系统
												①系统登录。请在研究生处网页登录研究生信息管理系统（教师端口），及时修改密码，完善填注个人信息，熟悉系统中的各项功能及信息；
												②核实教学班级名单。请以系统中教学编班的选课学生名单为准，注意实际课程考勤点名之间是否有差异，如有异常，请及时向二级院部研究生教育管理人员反映；
												③录入成绩。请各位老师在研究生处规定的考核结束后三个工作日内，在管理系统中登录成绩，并打印签字，与考务材料等一并，交院系研究生教务秘书汇总。</h4>
											<h4>（3）课程考试（考核）要求
												①考核形式。学位课程，原则上必须安排书面考试；非学位课程，可选择书面考试，也可选择申请进行非笔试课程考核（如按要求递交大型作业、总结性的论文总结报告等，并由任课教师组织现场答辩和记录），并填写“研究生课程非笔试课程考核方案申请表”，随教学进度表一并提交到院系；
												②考核时间。上半学期（第1～9周）内结束的课程，原则上安排在第10、11周内完成考试、考核工作，期末（第1～18周）结束的课程，非学位课程、二级学科点专业学位课在第18周内完成(包括考试)；公共学位课、一级学科专业学位课在第18周内完成授课等教学任务，考试安排在第19周内完成。
												③考试样卷。所有考试科目，请在授课结束前两周，按统一格式要求的样卷A、B卷及参考答案，交二级院部汇总。本学期上半学期课程，截止时间10月14日（第7周周五）；期末安排考试的课程，截止时间12月25日（第16周周五）；
												④监考教师。根据公布考试时间、考场等安排，由二级院部安排监考教师，原则上任课教师必须参加监考；
												⑤考核总评成绩。任课教师应在考核结束后的三个工作日内完成试卷评阅，给出总评成绩（平时成绩≤30%，否则必须附带递交平时作业材料），在研究生信息管理系统登录成绩、打印成绩单，并最终向院系部门提交案卷材料，包括：</h4>
											<h4>a.确认已在网上完成成绩登录、保存、提交；
												b.完成提交后，打印纸质课程成绩单，本人及主管领导签字（盖章），一式两份；
												c.试卷(考核材料)，按打印的学生成绩单序号排列，以研究生课程试卷袋封装；
												d.研究生课程教学手册，应填注相关日常教学信息。
												请各院系分管研究生工作的领导，落实研究生教育工作秘书/教务秘书（专职或兼职），加强研究生课程教学日常监管，统筹、安排和组织研究生培养进程中的各项阶段性工作。</h4>

											<h4>特此通知。</h4>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<footer class="text-right">
				<p>大作业-研究生导师双选系统-by许继中</p>
				</footer>
			</div>


		</div>
	</div>


</body>
</html>