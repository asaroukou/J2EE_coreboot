<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Liste cours</title>
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css">
    <link rel="stylesheet" href="assets/css/smoothproducts.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container"><a class="navbar-brand logo" href="#">LO54-MGR</a>
        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse"
             id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link active" href="/">accueil</a></li>
                <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-body" data-toggle="dropdown"
                                                 aria-expanded="/add-course" href="#">Cours</a>
                    <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation"
                                                              href="/all-course">Liste</a><a class="dropdown-item"
                                                                                             role="presentation"
                                                                                             href="/add-course">Ajouter</a>
                    </div>
                </li>
                <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-body" data-toggle="dropdown"
                                                 aria-expanded="false" href="/add-session">Sessions</a>
                    <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation"
                                                              href="/all-session">Liste</a><a class="dropdown-item"
                                                                                              role="presentation"
                                                                                              href="/add-session">Ajouter</a>
                    </div>
                </li>
                <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-body" data-toggle="dropdown"
                                                 aria-expanded="false" href="/add-site">sites</a>
                    <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation"
                                                              href="/all-site">Liste</a><a class="dropdown-item"
                                                                                           role="presentation"
                                                                                           href="/add-site">Ajouter</a>
                    </div>
                </li>
                <li class="nav-item dropdown"><a class="dropdown-toggle nav-link text-body" data-toggle="dropdown"
                                                 aria-expanded="false" href="/add-client">client</a>
                    <div class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation"
                                                              href="/all-client">Liste</a><a class="dropdown-item"
                                                                                             role="presentation"
                                                                                             href="/add-client">Ajouter</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<main class="page">
    <section class="clean-block features">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Cours</h2>
            </div>
            <div class="row">
                <div class="col-md-4" style="color: rgb(45,69,91);">
                    <form action="/search-course" method="POST">
                        <div class="form-group"><label>Mot clé</label><input class="form-control" type="text"
                                                                             name="code" required></div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Filtrer par mot clé</button>
                        </div>
                    </form>
                </div>
                <div class="col-md-4" style="color: rgb(45,69,91);">
                    <form action="/search-course" method="POST">
                        <div class="form-group"><label>Date</label><input class="form-control" type="date" name="date" required>
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary">Filtrer par date</button>
                        </div>
                    </form>
                </div>
                <div class="col-md-4" style="color: rgb(45,69,91);">
                    <form action="/search-course" method="POST">
                        <div class="form-group"><label>Site de formation</label><select class="form-control"
                                                                                        name="location_id" required>
                            <c:forEach var="i" items="${locations}">
                                <option value="${i.getId()}">${i.getCity()}</option>
                            </c:forEach>
                        </select></div>
                        <div
                                class="form-group">
                            <button type="submit" class="btn btn-primary">Filtrer par site</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="block-heading">
                <h3 class="text-info">
                    <c:if test="${filter == null}">
                        Tous les cours
                    </c:if>
                    <c:if test="${filter != null}">
                        Cours: ${filter} <a href="/all-course" style="color:red;">(supprimer filtre)</a>
                    </c:if>
                </h3>
            </div>
            <div class="row justify-content-center">
                <div class="table-responsive">
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th style="width: 265px;">Code</th>
                            <th>Titre</th>
                            <th style="width: 226px;">Edition</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="i" items="${courses}">
                            <tr>
                                <td>${i.getCode()}</td>
                                <td>${i.getTitle()}</td>
                                <td><a href="#">Modifier</a><span>&nbsp;|&nbsp;</span><a href="#">Supprimer</a></td>
                            </tr>
                        </c:forEach>


                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
</main>
<footer class="page-footer dark">
    <div class="footer-copyright">
        <p>© 2018 Copyright Text</p>
    </div>
</footer>
<script src="assets/js/jquery.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"></script>
<script src="assets/js/smoothproducts.min.js"></script>
<script src="assets/js/theme.js"></script>
</body>

</html>