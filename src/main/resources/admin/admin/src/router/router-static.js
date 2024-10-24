import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import baoxiu from '@/views/modules/baoxiu/list'
    import chewei from '@/views/modules/chewei/list'
    import cheweiFenpei from '@/views/modules/cheweiFenpei/list'
    import churu from '@/views/modules/churu/list'
    import dictionary from '@/views/modules/dictionary/list'
    import fangwu from '@/views/modules/fangwu/list'
    import feiyong from '@/views/modules/feiyong/list'
    import gonggao from '@/views/modules/gonggao/list'
    import liuyan from '@/views/modules/liuyan/list'
    import sixin from '@/views/modules/sixin/list'
    import wuye from '@/views/modules/wuye/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryBaoxiu from '@/views/modules/dictionaryBaoxiu/list'
    import dictionaryBaoxiuZhuangtai from '@/views/modules/dictionaryBaoxiuZhuangtai/list'
    import dictionaryChewei from '@/views/modules/dictionaryChewei/list'
    import dictionaryCheweiZhuangtai from '@/views/modules/dictionaryCheweiZhuangtai/list'
    import dictionaryChuru from '@/views/modules/dictionaryChuru/list'
    import dictionaryFangwuDanyuan from '@/views/modules/dictionaryFangwuDanyuan/list'
    import dictionaryFangwuLouhao from '@/views/modules/dictionaryFangwuLouhao/list'
    import dictionaryFeiyong from '@/views/modules/dictionaryFeiyong/list'
    import dictionaryFeiyongZhuangtai from '@/views/modules/dictionaryFeiyongZhuangtai/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryWuye from '@/views/modules/dictionaryWuye/list'
    import fenpei from '@/views/modules/cheweiFenpei/add-or-update'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryBaoxiu',
        name: '报修类型',
        component: dictionaryBaoxiu
    }
    ,{
        path: '/dictionaryBaoxiuZhuangtai',
        name: '报修状态',
        component: dictionaryBaoxiuZhuangtai
    }
    ,{
        path: '/dictionaryChewei',
        name: '车位类型',
        component: dictionaryChewei
    }
        ,{
            path: '/fenpei',
            name: '车位分配',
            component: fenpei
        }

    ,{
        path: '/dictionaryCheweiZhuangtai',
        name: '车类状态',
        component: dictionaryCheweiZhuangtai
    }
    ,{
        path: '/dictionaryChuru',
        name: '出入类型',
        component: dictionaryChuru
    }
    ,{
        path: '/dictionaryFangwuDanyuan',
        name: '单元',
        component: dictionaryFangwuDanyuan
    }
    ,{
        path: '/dictionaryFangwuLouhao',
        name: '楼号',
        component: dictionaryFangwuLouhao
    }
    ,{
        path: '/dictionaryFeiyong',
        name: '缴费类型',
        component: dictionaryFeiyong
    }
    ,{
        path: '/dictionaryFeiyongZhuangtai',
        name: '缴费状态',
        component: dictionaryFeiyongZhuangtai
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryWuye',
        name: '人员类型',
        component: dictionaryWuye
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/baoxiu',
        name: '报修',
        component: baoxiu
      }
    ,{
        path: '/chewei',
        name: '车位',
        component: chewei
      }
    ,{
        path: '/cheweiFenpei',
        name: '车位分配',
        component: cheweiFenpei
      }
    ,{
        path: '/churu',
        name: '出入',
        component: churu
      }
    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/fangwu',
        name: '房屋',
        component: fangwu
      }
    ,{
        path: '/feiyong',
        name: '物业费缴纳',
        component: feiyong
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/liuyan',
        name: '物业人员投诉',
        component: liuyan
      }
    ,{
        path: '/sixin',
        name: '我的私信',
        component: sixin
      }
    ,{
        path: '/wuye',
        name: '物业人员',
        component: wuye
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
