<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Catalogue des produits</title>
</head>
<body>
<h2>Utilisateur connecté : ${sessionScope.user}</h2>
<h1>Catalogue des produits</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prix (€)</th>
    </tr>

    <!-- Boucle sur la liste de produits transmise par la Servlet -->
    <c:forEach var="produit" items="${listeProduits}">
        <tr>
            <td>${produit.id}</td>
            <td>${produit.nom}</td>
            <td>${produit.prix}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>