var pager = {start:0,limit:10};
$(function () {
    var categoryId = $("#categoryId").text();

    //初始化文章
    $.ajax({
        type: 'GET',
        url: '/article/category/'+categoryId,
        data:{pager:pager},
        success: function (data){
            $("#main").html(data);
            /*分享初始化*/
            $("#socialShare").socialShare({
                content: '这是我的个人博客内容',
                url:'http://www.jiangbin.net.cn',
                title:'这是我的个人博客标题',
                summary:'这是我的博客描述',
                pic:'http://pq0c9fl0p.bkt.clouddn.com/IMG_20180921_145957.jpg'
            });

            //初始化文章分页信息
            //初始化文章
            $.ajax({
                type: 'GET',
                url: '/pager/category/load',
                data:{pager:pager,categoryId:categoryId},
                success: function (data){
                    pager = data;
                    $('.M-box').pagination({
                        pagerCount:pager.totalPageNum, //	总页数
                        current:pager.pager,//当前第几页
                        showData:pager.limit,//每页显示的条数
                        count:3,//	当前选中页前后页数
                        callback:function(api){
                            $('.now').text(api.getCurrent());
                        }
                    },function(api){
                        $('.now').text(api.getCurrent());
                    });
                }
            });
        }
    });


})