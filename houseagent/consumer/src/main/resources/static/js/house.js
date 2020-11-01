$(function () {
    var tab=$("#labelList");
$.ajax({
    type:"GET",
    url:"/getHouseInfoList",
    dataType:"json",
    success:function (data) {
        var trs="<tr><th>序号</th><th>描述</th><th>户型</th><th>租金</th><th>发布时间</th></tr><br/>";
        tab.html("");

        for(var i=0;i<data.length;i++){
            trs+="<a><td>"+(i+1)+"</td>\n"+
                "<td>"+data[i].houseDesc+"</td>\n"+
                "<td><a href='addhouse.html'>"+data[i].typeName+"</a></td>\n"+
                "<td>"+data[i].monthlyRent+"</td>\n"+
                "<td>"+data[i].publishDate+"</td></tr>";
        }
        tab.html(trs);

    },
    error:function (a) {
        alert("显示房屋信息失败");

    }
})

});

//户型
$(function () {
    var type=$("#type");
    $.ajax( {
        type:"GET",
        url:"/getTypeList",
        dataType:"json",
        success:function (data) {
            type.html("");
            var option="<option>--户型--</option>";
            for(var i=0;i<data.length;i++){
                option+="<option value=+'"+data[i].id+"'>"+data[i].typeName+"</option>"
            }
            type.html(option);
        },
        error:function (b) {
            alert("显示户型失败");

        }
    })
});

//添加房源
// function add() {
//     $.ajax( {
//         type:"GET",
//         url:"/getTypeList",
//         dataType:"json",
//         success:function (data) {
//             type.html("");
//             var option="<option>--户型--</option>";
//             for(var i=0;i<data.length;i++){
//                 option+="<option value=+'"+data[i].id+"'>"+data[i].typeName+"</option>"
//             }
//             type.html(option);
//         },
//         error:function (b) {
//             alert("显示户型失败");
//
//         }
//     })
//
// }