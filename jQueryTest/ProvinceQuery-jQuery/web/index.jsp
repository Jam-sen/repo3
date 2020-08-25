<%--
  Created by IntelliJ IDEA.
  User: ys
  Date: 2020/8/13
  Time: 19:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="application/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                async:false,
                url: "InitProvince",
                type: "get",
                dataType:"json",
                success: function (result) {
                    $.each(result,function(index,element){
                        $("#province").append("<option id='"+element.id+"'>"+element.name+"</option>");
                    })
                }
            })
            $(document).ready(addCity());
            $("#province").change(addCity);
        })
        function addCity(){
            $("#city").empty();
            $.ajax({
                url:"InitCity",
                data:{"id":$("#province>option:selected").attr("id")},
                type:"post",
                dataType:"json",
                success:function(result){
                    $.each(result,function(index,element){
                        $("#city").append("<option>"+element.name+"</option>")
                    })
                }
            })
        }
    </script>
    <title>级联查询</title>
</head>
<body>
<table>
    <tr>
        <td>省份</td>
        <td>
            <select id="province">
            </select>
        </td>
    </tr>
    <tr>
        <td>城市</td>
        <td>
            <select id="city">
                <option>请选择您的城市</option>
            </select>
        </td>
    </tr>
</table>
</body>
</html>
