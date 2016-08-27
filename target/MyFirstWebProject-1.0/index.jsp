<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html ng-app>
<head>
</head>
<body>
<table>
    <tr>
        <h1>Фильтр</h1>
        <td width="150">
            <form action="" method="GET">
                <p><select  name="name_do1">
                    <option disabled>Выполнено/Невыполнено</option>
                    <option value="all">Все</option>
                    <option value="no">Невыполнено</option>
                    <option value="yes">Выполнено</option>

                </select></p>
                <input type="submit" value="Отфильтровать" ng-click="randomUserModelAlert()"/>
                </form>

        </td>

        <td width="150">

        </td>
        <td width="150">

        </td>
    </tr>
    <tr>
        <td>
           <h4>Наименование</h4>

        </td>

        <td>
            <h4>Результат</h4>
        </td>
        <td>
            <h4>Срок давности</h4>
        </td>
    </tr>
    <tr>
        <td>
${textA}

        </td>

        <td>
            ${textB}
                 </td>
        <td>
            ${textD}
        </td>
    </tr>
    <tr>
        <td colspan="3">
            <form action="" method="GET">
                <select name="name_update">
                    <option disabled>Выберите задание</option>

                    ${textC}
                </select>
                <select name="name_do_update">
                    <option disabled>Выполнено/Невыполнено</option>
                    <option value="Невыполнено">Невыполнено</option>
                    <option value="Выполнено">Выполнено</option>

                </select>
                <select name="request_update">
                    <option disabled>Новое/Старое</option>
                    <option value="Новое">Новое</option>
                    <option value="Старое">Старое</option>

                </select>
                <input type="submit" value="Изменить" ng-click="randomUserModelAlert()"/>
            </form>
            <form action="" method="GET">
                <input type="text" type="submit" name = "name" ng-model="name" placeholder="Введите новое задание">
                <select name="name_do">
                    <option disabled>Выполнено/Невыполнено</option>
                    <option value="Невыполнено">Невыполнено</option>
                    <option value="Выполнено">Выполнено</option>

                </select>
                <select name="request">
                    <option disabled>Новое/Старое</option>
                    <option value="Новое">Новое</option>
                    <option value="Старое">Старое</option>

                </select>
                <input type="submit" value="Создать" ng-click="randomUserModelAlert()"/>

            </form>
        </td>
    </tr>
    </table>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.11/angular.min.js"></script>
</body>
</html>