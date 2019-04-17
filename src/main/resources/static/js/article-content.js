/**
 * Created by jiang on 2017/4/16.
 */
$(function() {
    var testEditormdView;
    $('#main').addClass('loaded');
    $.get("", function(markdown) {
        testEditormdView = editormd.markdownToHTML("article-content", {
            htmlDecode      : "style,script,<iframe",  // you can filter tags decode
            emoji           : true,
            taskList        : true,
            tex             : true,  // 默认不解析
            flowChart       : true,  // 默认不解析
            sequenceDiagram : true,  // 默认不解析 // 默认不解析
        });

        //console.log("返回一个 jQuery 实例 =>", testEditormdView);

        // 获取Markdown源码
        //console.log(testEditormdView);

        //alert(testEditormdView.getMarkdown());
    });

    // $('pre li').each(function(i, block) {
    //     hljs.highlightBlock(block);
    // }

    /*分享初始化*/
    $("#socialShare").socialShare({
        content: $("#"),
        url:getRootPath()+$("#article-url").attr("href"),
        title:$("#article-title").text(),
        summary:'个人博客分享,欢迎指教',
        pic:'http://pq0c9fl0p.bkt.clouddn.com/IMG_20180921_145957.jpg'
    });

    $('#loader-wrapper .load_title').remove();
});



function loadCategory(categoryId) {
    var loadPager = {start:0,limit:10};
    $.ajax({
        type: 'GET',
        url: '/category/load/' + categoryId,
        data: {pager: pager},
        success: function (data) {
            $("#main").html(data);
        }
    });

}

function loadTag(tagId) {
    var loadPager = {start:0,limit:10};

    $.ajax({
        type: 'GET',
        url: '/tag/load/'+tagId,
        data: {pager: loadPager},
        success: function (data) {
            $("#main").html(data);
        }
    });
}


function getRootPath() {
    //获取当前网址，如： http://localhost:8080/GameFngine/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： GameFngine/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8080
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/GameFngine
    var projectName = pathName.substring(0,
        pathName.substr(1).indexOf('/') + 1);
    return (localhostPaht + projectName);
}
