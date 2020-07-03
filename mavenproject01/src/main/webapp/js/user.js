var vue = new Vue({
    el: "#app",
    data: {
        user: {id: "", username: "aaa", password: "", age: "", sex: "", email: ""},
        userList: [],
        pagination: {
            currentPage: 1,
            pageSize: 3,
            pages:5,

        }
    },
    methods: {
        findAll: function () {
            let param = "?currentPage=" + this.pagination.currentPage + "&pageSize=" + this.pagination.pageSize;
            axios.get("/item/findAll" + param).then(function (response) {
                /*alert(response);
                alert(response.data);
                alert(JSON.stringify(response));
                alert(JSON.stringify(response.data));*/
                vue.userList = response.data.list;
               vue.pagination.currentPage= response.data.pageNum;
               vue.pagination.pageSize= response.data.pageSize;
               vue.pagination.pages= response.data.pages;
               vue.pagination.nextPage= response.data.nextPage;
               vue.pagination.prePage= response.data.prePage;
            }).catch(function (response) {

            });

            /*  axios.post(url,{}).then(function(response){

              });*/
        },
        hrefByPage:function (id) {
            axios.get("/item/findAll?currentPage="+id+"&pageSize="+ vue.pagination.pageSize).then(function (response) {
                /*alert(response);
                alert(response.data);
                alert(JSON.stringify(response));
                alert(JSON.stringify(response.data));*/
                vue.userList = response.data.list;
                vue.pagination.currentPage= response.data.pageNum;
                vue.pagination.pageSize= response.data.pageSize;
                vue.pagination.pages= response.data.pages;
                vue.pagination.nextPage= response.data.nextPage;
                vue.pagination.prePage= response.data.prePage;
            }).catch(function (response) {

            });
        },
        goNextPage:function () {
            this.hrefByPage(this.pagination.nextPage);
        },
        goPrePage:function () {
            this.hrefByPage(this.pagination.prePage)
        }
    },
    watch: { //方式2：使用vue实例提供的watch选项
            'pagination.pageSize': (newValue, oldValue) => {
                let param = "?currentPage=1&pageSize=" +newValue;
                axios.get("/item/findAll" + param).then(function (response) {
                    /*alert(response);
                    alert(response.data);
                    alert(JSON.stringify(response));
                    alert(JSON.stringify(response.data));*/
                    vue.userList = response.data.list;
                    vue.pagination.currentPage= response.data.pageNum;
                    vue.pagination.pageSize= response.data.pageSize;
                    vue.pagination.pages= response.data.pages;
                    vue.pagination.nextPage= response.data.nextPage;
                    vue.pagination.prePage= response.data.prePage;
                }).catch(function (response) {

                });
            },


    },
    mounted() {
        this.findAll();
    }
});