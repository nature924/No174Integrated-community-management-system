const base = {
    get() {
        return {
            url : "http://localhost:8080/zonghexiaoqiguanlixitong/",
            name: "zonghexiaoqiguanlixitong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/zonghexiaoqiguanlixitong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "综合小区管理系统"
        } 
    }
}
export default base
