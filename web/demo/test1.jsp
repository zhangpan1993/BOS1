<%--
  Created by IntelliJ IDEA.
  User: zhangpan
  Date: 2020/12/14
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>演示1</title>

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ztree/zTreeStyle.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree/jquery.ztree.all-3.5.js"></script>

</head>
<body class="easyui-layout">
    <div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
    <div data-options="region:'west',split:true,title:'West'" style="width:150px;padding:10px;">

        <div class="easyui-accordion" data-options="fit:true">
            <div title="Language" style="padding:5px;">
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="addPanel()">打开面板1</a>
            </div>

            <div title="Java" style="padding:5px;">

                <script>

                    $(function() {
                        //1.节点配置
                        var setting = {
                            data: {
                                simpleData: {
                                    enable: true//使用简单树形json数据
                                }
                            },
                            callback:{
                                onClick:function(event, treeId, treeNode){
                                    /* 在内容中添加tabbar */
                                    //获取tabs中是否存在当前要展开的内容
                                    if(!treeNode.isParent){
                                        var tab = $("#tt").tabs("exists",treeNode.name);
                                        if(tab){
                                            //如果已经存在tabs中了，就打开选中
                                            $("#tt").tabs("select",treeNode.name);
                                        }else{
                                            $('#tt').tabs('add',{
                                                title: treeNode.name,
                                                content: '<div >Content测试</div>',
                                                closable: true
                                            });
                                        }

                                    }
                                }
                            }
                        };

                        //2.通过发送网络请求来获取树型菜单的数据
                        var url = "${pageContext.request.contextPath}/json/menu.json"
                        /* 1.post网络请求最后一个参数为dataType
                           2.可选。规定预期的服务器响应的数据类型。
                            默认执行智能判断（xml、json、script 或 html）*/
                        $.post(url,function(data){
                            //3.初始化节点内容
                            $.fn.zTree.init($("#tree"), setting, data);
                        },"json");

                    });



                </script>
                <ul id="tree" class="ztree"></ul>
            </div>
            <div title="C#" style="padding:5px;">
                <p>C# </p>
            </div>
            <div title="Ruby" style="padding:5px;">
                <p>A dynamic.</p>
            </div>
            <div title="Fortran" style="padding:5px;">
                <p>Fortran</p>
            </div>
        </div>

    </div>
    <div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
    <div data-options="region:'south',border:false" style="height:50px;background:#A9FACD;padding:10px;">south region</div>
    <div data-options="region:'center',title:'Center'">

        <div id="tt" class="easyui-tabs" data-options="fit:true">
        </div>

    </div>

    <script type="text/javascript">
        var index = 0;
        function addPanel(){
            index++;
            $('#tt').tabs('add',{
                title: 'Tab'+index,
                content: '<div style="padding:10px">Content'+index+'</div>',
                closable: true
            });
        }
        function removePanel(){
            var tab = $('#tt').tabs('getSelected');
            if (tab){
                var index = $('#tt').tabs('getTabIndex', tab);
                $('#tt').tabs('close', index);
            }
        }

    </script>
</body>
</html>
