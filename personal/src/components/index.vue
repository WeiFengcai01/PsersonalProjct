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
        <div style="width: 1370px;margin: 10px auto;border-radius: 4px;">
        <el-container class="content">
            <el-header style="height: 150px;margin: 16px">
                <el-row>
                    <el-col :span="5"><div class="demo-basic--circle">
                        <div class="block"><el-avatar :size="150" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar></div>
                        <div class="block" v-for="size in sizeList" :key="size">
                            <el-avatar :size="size" :src="circleUrl"></el-avatar>
                        </div>
                    </div></el-col>
                    <el-col :span="19"><div class="grid-content bg-purple-light"><p>
                        个人主页是从英文Personal Homepage翻译而来，更适合的意思是"属于个人的网站"。就内容而言，个人站点所提供的多半是纯文字或图片等静态信息，而就站点的性质来说，则以教学或特定主题（如历史、古典文学、电玩、旅游记录等）的站台为多数。然而，经过多年的...
                    </p></div></el-col>
                </el-row>
            </el-header>
            <el-container  style="height: 64.5vh">
                <el-aside style="margin-right: 10px;">
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
                        <el-menu-item-group>
                            <template slot="title">分组一</template>
                            <el-menu-item index="1-1">选项1</el-menu-item>
                            <el-menu-item index="1-2">选项2</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="分组2">
                            <el-menu-item index="1-3">选项3</el-menu-item>
                        </el-menu-item-group>
                        <el-submenu index="1-4">
                            <template slot="title">选项4</template>
                            <el-menu-item index="1-4-1">选项1</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                    <el-menu-item index="2">
                        <i class="el-icon-menu"></i>
                        <span slot="title">导航二</span>
                    </el-menu-item>
                    <el-menu-item index="3" disabled>
                        <i class="el-icon-document"></i>
                        <span slot="title">导航三</span>
                    </el-menu-item>
                    <el-menu-item index="4">
                        <i class="el-icon-setting"></i>
                        <span slot="title">导航四</span>
                    </el-menu-item>
                </el-menu></el-aside>
                <el-main>
                    <div style="background-color: white;box-shadow: 0 2px 4px rgba(0,0,0,0.12), 0 0 6px rgba(0, 0, 0, .04);padding:30px;" v-model="brotext">

                        <el-descriptions class="margin-top" title="带边框列表" :column="4" :size="size" border style="height: 400px">
                            <template slot="title">
                                <el-row>
                                    <el-col :span="12">
                                        <el-avatar :size="70" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
                                    </el-col>
                                    <el-col :span="12">66666</el-col>
                                </el-row>
                            </template>
                            <template slot="extra">
                                <el-button type="primary" size="small">操作</el-button>
                            </template>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-user"></i>
                                    用户名
                                </template>
                                kooriookami
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-mobile-phone"></i>
                                    手机号
                                </template>
                                18100000000
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
                                    <i class="el-icon-location-outline"></i>
                                    居住地
                                </template>
                                苏州市
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
                                    <i class="el-icon-location-outline"></i>
                                    居住地
                                </template>
                                苏州市
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
                            </el-descriptions-item>           <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-office-building"></i>
                                    联系地址
                                </template>
                                江苏省苏州市吴中区吴中大道 1188 号
                            </el-descriptions-item>           <el-descriptions-item>
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
        </el-container>
        </div>
        <el-footer class="footer">
            <div>联系我</div>
        </el-footer>
    </el-container>
</template>

<script>
    export default {
        name: "index",
        created() {
            let _this=this
            this.$ajax.get("book/findById/6").then( (resp)=> {
                console.log(resp.data)
                _this.brotext=resp.data

            })
        },
        data() {
            return {
                activeIndex: '1',
                size:"medium",
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
        background-color: #545c64;
        color: #333;

    }





    .bg-purple-light {
        background: #e5e9f2;
    }
    .grid-content {
        border-radius: 4px;
        min-height: 36px;
    }

    .footer {
        height: 50px;
    }
    .el-main[data-v-47323bf2] {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: -1px;
    }
    .el-main[data-v-47323bf2] {
        background-color: #E9EEF3;
        color: #333;
        text-align: center;
        line-height: -1px;
    }

</style>