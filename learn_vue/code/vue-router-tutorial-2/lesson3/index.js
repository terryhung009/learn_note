const User = {
  template:`
      <div>
      <h1>User</h1>  
        <div>
          <router-link to="/user/1001">User 1001</router-link></br>
          <router-link to="/user/1002">User 1002</router-link>
        </div>
      <router-view></router-view>
      </div>
  `


}
const UserDetail = {
  template:`
      <div>
      <h2>UserDetail {{ $route.params.id }} </h2>
      </br>
      <router-link to="/user/">User</router-link>
      <router-link to="profile">profile</router-link>
      <router-link to="post">post</router-link>
      <router-view></router-view>
      </div>
  `


}

const UserProfile ={
  template:`
      <div>
      UserProfile
      
      <router-view></router-view>
      </div>
  `
}

const UserPosts ={
  template:`
      <div>
      UserPosts
      <router-view></router-view>
      </div>
  `
}

const router = new VueRouter({
  routes:[
    {
      path:'/user/:id',
      component:User,
      children:[
        {
          path:'/user/:id' ,
          component:UserDetail,
          children:[
            {
              path:'profile',
              component:UserProfile,
            },
            {
              path:'post',
              component:UserPosts
    
    
            }
          ]
        },
        
      ]
    },
    
    
  ]



})



new Vue({
  el:'#app',
  router,
})