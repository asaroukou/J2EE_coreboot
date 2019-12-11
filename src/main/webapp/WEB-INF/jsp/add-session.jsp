<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Ajouter Session</title>
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
<main class="page pricing-table-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Créer une session</h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in,
                    mattis vitae leo.</p>
            </div>
            <form action="/add-session" method="POST">
                <div class="form-group"><label>Code du cours</label>
                    <select class="form-control" name="course_code" required>
                        <c:forEach var="i" items="${courses}">
                            <option value="${i.getCode()}">${i.getCode()} - ${i.getTitle()}</option>
                        </c:forEach>
                    </select></div>
                <div
                        class="form-group"><label>Site</label><select class="form-control" name="location_id" required>
                    <c:forEach var="i" items="${locations}">
                        <option value="${i.getId()}">${i.getCity()}</option>
                    </c:forEach>
                </select></div>
                <div class="form-group"><label>Début de session</label><input class="form-control" type="date"
                                                                              name="start_date" required></div>
                <div class="form-group"><label>Fin de session</label><input class="form-control" type="date"
                                                                            name="end_date" required></div>
                <div class="form-group"><label>Places disponibles</label><input class="form-control" type="number"
                                                                                name="max" required></div>
                <div class="form-group">
                    <button class="btn btn-primary btn-block" type="submit">Créer session</button>
                </div>
            </form>
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