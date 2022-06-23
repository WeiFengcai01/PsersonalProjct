<template>
    <el-container class="home_container">
        <el-header>
            <div class="home_title">个人主页管理平台</div>
            <div class="home_userinfoContainer">
                <el-dropdown @command="handleCommand">
  <span class="el-dropdown-link home_userinfo">
    {{currentUserName}}<i class="el-icon-arrow-down el-icon--right home_userinfo"></i>
  </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item command="sysMsg">系统消息</el-dropdown-item>
                        <el-dropdown-item command="MyArticle">我的文章</el-dropdown-item>
                        <el-dropdown-item command="MyHome">个人主页</el-dropdown-item>
                        <el-dropdown-item command="logout" divided>退出登录</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </el-header>
        <el-container>
            <el-aside width="200px">
                <el-menu
                        default-active="2"
                        class="el-menu-vertical-demo"
                        @open="handleOpen"
                        @close="handleClose"
                        background-color="#545c64"
                        text-color="#fff"
                        active-text-color="#ffd04b">
                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span>导航一</span>
                        </template>

                            <el-menu-item index="1-1">选项1</el-menu-item>

                    </el-submenu>

                    <el-submenu index="2">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span>导航一</span>
                        </template>

                        <el-menu-item index="2-1">选项1</el-menu-item>

                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-container>
                <el-main>
                    <el-breadcrumb separator-class="el-icon-arrow-right">
                        <el-breadcrumb-item :to="{ path: '/home' }">首页</el-breadcrumb-item>
                        <el-breadcrumb-item v-text="this.$router.currentRoute.name"></el-breadcrumb-item>
                    </el-breadcrumb>
                    <keep-alive>
                        <router-view v-if="this.$route.meta.keepAlive"></router-view>
                    </keep-alive>
                    <router-view v-if="!this.$route.meta.keepAlive"></router-view>
                </el-main>
            </el-container>
        </el-container>
    </el-container>
</template>

<script>
    export default {
        name: "Index",
        methods: {
            handleCommand(command){
                var _this = this;
                if (command == 'logout') {
                    this.$confirm('注销登录吗?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(function () {
                        getRequest("/logout")
                        _this.currentUserName = '游客';
                        _this.$router.replace({path: '/'});
                    }, function () {
                        //取消
                    })
                }
            },
            handleOpen(key, keyPath) {
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                console.log(key, keyPath);
            }
        },
        mounted: function () {
            // this.$alert('为了确保所有的小伙伴都能看到完整的数据演示，数据库只开放了查询权限和部分字段的更新权限，其他权限都不具备，完整权限的演示需要大家在自己本地部署后，换一个正常的数据库用户后即可查看，这点请大家悉知!', '友情提示', {
            //     confirmButtonText: '确定',
            //     callback: action => {
            //     }
            // });
            var _this = this;
            getRequest("/currentUserName").then(function (msg) {
                _this.currentUserName = msg.data;
            }, function (msg) {
                _this.currentUserName = '游客';
            });
        },
        data(){
            return {
                currentUserName: ''
            }
        }
    }

</script>

<style scoped>
    .home_container {
        height: 100%;
        position: absolute;
        top: 0px;
        left: 0px;
        width: 100%;
    }

    .el-header {
        background-color: #20a0ff;
        color: #333;
        text-align: center;
        display: flex;
        align-items: center;
        justify-content: space-between;
    }

    .el-aside {
        background-color: #545c64;
    }

    .el-main {
        background-color: #fff;
        color: #000;
        text-align: center;
    }

    .home_title {
        color: #fff;
        font-size: 22px;
        display: inline;
    }

    .home_userinfo {
        color: #fff;
        cursor: pointer;
    }

    .home_userinfoContainer {
        display: inline;
        margin-right: 20px;
    }
</style>