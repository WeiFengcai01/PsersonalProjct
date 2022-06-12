<template>
    <el-container>
        <el-header>
            <template>
                <el-row :gutter="20">
                    <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
                    <el-col :span="16">
                        <el-menu
                                :default-active="$route.path"
                                class="el-menu-demo"
                                mode="horizontal" @select="handleSelect" router>
                            <template v-for="(item,index) in this.$router.options.routes" v-if="!item.hidden">
                                <el-menu-item :index="item.path" :key="item.path">{{item.name}}</el-menu-item>
                            </template>

                    </el-menu>






                    </el-col>
                    <el-col :span="4">

                        <div class="grid-content bg-purple">
                            <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                            <el-dropdown trigger="click" @command="handleCommand">
                                  <span class="el-dropdown-link">
                                    下拉菜单<i class="el-icon-arrow-down el-icon--right"></i>
                                  </span>
                                <el-dropdown-menu slot="dropdown">
                                    <el-dropdown-item command="a">黄金糕</el-dropdown-item>
                                    <el-dropdown-item command="b">狮子头</el-dropdown-item>
                                    <el-dropdown-item command="c">螺蛳粉</el-dropdown-item>
                                    <el-dropdown-item command="d" disabled>双皮奶</el-dropdown-item>
                                    <el-dropdown-item command="e" divided>蚵仔煎</el-dropdown-item>
                                </el-dropdown-menu>
                            </el-dropdown>
                        </div></el-col>
                </el-row>
            </template>
        </el-header>
        <el-container class="content">
            <el-aside>aside</el-aside>
            <el-main>
            <div style="background-color: white;box-shadow: 0 2px 4px rgba(0,0,0,0.12), 0 0 6px rgba(0, 0, 0, .04);padding:30px;" v-model="brotext">
                <el-descriptions class="margin-top" title="带边框列表" :column="3" :size="size" border  >
                    <template slot="title">

                        <div class="grid-content bg-purple">
                                <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                        </div>
                    </template>
                    <template slot="extra">
                        <el-button type="primary" size="small" @click="czbtn">操作</el-button>
                    </template>
                    <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-user"></i>
                            用户名
                        </template>
                        {{brotext.name}}
                    </el-descriptions-item>
                    <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-mobile-phone"></i>
                            手机号
                        </template>
                        {{brotext.price}}
                    </el-descriptions-item>

                    <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-location-outline"></i>
                            居住地
                        </template>
                        苏州市
                    </el-descriptions-item>
                    <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-tickets"></i>
                            备注
                        </template>
                        <el-tag size="small">学校</el-tag>
                    </el-descriptions-item>
                    <el-descriptions-item>
                        <template slot="label">
                            <i class="el-icon-office-building"></i>
                            联系地址
                        </template>
                        江苏省苏州市吴中区吴中大道 1188 号
                    </el-descriptions-item>
                </el-descriptions>

            </div>

            </el-main>
        </el-container>
        <el-footer class="footer">footer</el-footer>
    </el-container>
</template>

<script>
    export default {
        name: "index",
        created() {
            let _this=this
            this.$ajax.get("book/findById/6").then(function (resp) {
                _this.brotext=resp.data

            })
        },
        data() {
            return {
                activeIndex: '1',
                size:'',
                brotext:''
            };
        },
        methods: {
            handleSelect(key, keyPath) {
                console.log(key, keyPath);
            },
            handleCommand(command) {
                this.$message('click on item ' + command);
            },
            czbtn(){
                let _this=this
                _this.$router.push('/message')

            }
        }
    }
</script>

<style scoped>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: 160px;
    }
    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }
    .el-row {
        margin-bottom: 20px;
    }

    .el-col {
        border-radius: 4px;
    }
    .bg-purple-dark {
        background: #99a9bf;
    }
    .bg-purple {
        background: #d3dce6;
    }
    .bg-purple-light {
        background: #e5e9f2;
    }
    .grid-content {
        border-radius: 4px;
        min-height: 36px;
    }
    .row-bg {
        padding: 10px 0;
        background-color: #f9fafc;
    }
    .text {
        font-size: 14px;
    }

    .item {
        margin-bottom: 18px;
    }

    .clearfix:before,
    .clearfix:after {
        display: table;
        content: "";
    }
    .clearfix:after {
        clear: both
    }

    .box-card {
        width: 480px;
    }
    .content {
         min-height: calc(100vh - 140px);
     }
    .footer {
        height: 50px;
    }

</style>