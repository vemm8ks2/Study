<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Register</title>

    <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

	<%@include file="../includes/header.jsp" %>

	<!-- Begin Page Content -->
    <div class="container-fluid">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-12">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Board Register</h1>
                            </div>
                                <div class="form-group">
                                	<label>Bno</label>
                                	<input class="form-control" name="bno" value='<c:out value="${board.bno}" />' readonly="readonly" />
                                </div>
                                <div class="form-group">
                                	<label>Title</label>
                                	<input class="form-control" name="title" value='<c:out value="${board.title}" />' readonly="readonly" />
                                </div>
                                <div class="form-group">
                                	<label>Text area</label>
                                	<textarea class="form-control" rows="5" name="content" readonly="readonly"><c:out value="${board.content}" /></textarea>
                                </div>
                                <div class="form-group">
                                	<label>Writer</label>
                                	<input class="form-control" name="writer" value='<c:out value="${board.writer}" />' readonly="readonly" />
                                </div>
                                <div class="d-flex justify-content-center">
	                                <button 
	                                	data-oper="modify"
	                                	onclick="location.href='/board/modify?bno=<c:out value="${board.bno}" />'" 
	                                	class="btn btn-default"
                                	>
	                                	Modify
	                                </button>
	                                <button 
	                                	data-oper="list"
	                                	onclick="location.href='/board/list'" 
	                                	class="btn btn-default mx-2"
                                	>
	                                	List
	                                </button>
	                                
	                                <form id="operForm" action="/board/modify" method="get">
	                                	<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}" />' />
	                                	<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}" />' />
	                                	<input type="hidden" name="amount" value='<c:out value="${cri.amount}" />' />
	                                	<input type="hidden" name="keyword" value='<c:out value="${cri.keyword}" />' />
	                                	<input type="hidden" name="type" value='<c:out value="${cri.type}" />' />
	                                </form>
                                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- /.container-fluid -->

	<%@include file="../includes/footer.jsp" %>
	
	<script type="text/javascript">
		$(document).ready(function() {
			const operForm = $("#operForm");
			
			$("button[data-oper='modify']").on("click", function(e) {
				operForm.attr("action", "/board/modify").submit();
			})
			
			$("button[data-oper='list']").on("click", function(e) {
				operForm.find("#bno").remove();
				operForm.attr("action", "/board/list")
				operForm.submit();
			})
		})
	</script>

</body>

</html>