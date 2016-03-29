angular.module('routerApp', ['ngRoute'])
 .config(function ($routeProvider) {
//Module의 config API를 사용하면 서비스 제공자provider에 접근할 수 있다. 여기선 $route 서비스 제공자를 인자로 받아온다. 
  $routeProvider
//$routeProvider의 when 메소드를 이용하면 특정 URL에 해당하는 라우트를 설정한다. 이때 라우트 설정객체를 전달하는데 <ng-view>태그에 삽입할 탬플릿에 해당하는 url을 설정객체의 templateUrl 속성으로 정의한다.
    .when('/home', {templateUrl: './SP02.jsp'})
    .when('/userList', {templateUrl: './SP03.jsp', controller: 'userListCtrl'})
//라우트 설정객체에 controller 속성을 통하여 해당 화면에 연결되는 컨트롤러 이름을 설정할 수 있다.
    .otherwise({redirectTo: '/home'});
//otherwise 메소드를 통하여 브라우저의 URL이 $routeProivder에서 정의되지 않은 URL일 경우에 해당하는 설정을 할 수 있다. 여기선 ‘/home’으로 이동시키고 있다.
  }).
  controller('userListCtrl',function($scope) {
//사용자 관리화면의 컨트롤러를 정의한다. 이 컨트롤러는 URL이 ‘/userList’일 경우에만 적용이 된다. 이전의 템플릿 코드에서 별도로 ng-controller 지시자를 사용하지 않고 $routeProvider에서 라우트를 정의할 때 해당 컨트롤러와 연결되는 화면을 정의하였다.
    $scope.userList = [
    {
      name : '미나',
      email : 'mina@gmail.com',
      regDate : '2012-03-12'
    },
    {
      name : '제시카',
      email : 'jess@gmail.com',
      regDate : '2012-03-12'
    }
  ];
});

(function(){
	/*
	    앵귤러 모듈 선언
	    C에서는 main() 함수가 프로그램의 시작 지점이지만,
	    angular 에서는 특별한 시작 지점이 존재하지 않는다. 
	    다만 여러개의 모듈들이 존재하고, ngApp에서 시작 지점으로 특정 모듈을
	    지정하는 방식을 취한다.
	    
	    아래 모듈 선언에서는 설명을 위해 다소 파라메터들을 줄단위로 열거했다.
	*/
	    var myApp = angular.module
	    (
	        'myApp', //선언할 모듈명
	        [], //선언하는 모듈에서 사용할 다른 모듈들(디펜던시). 예  'ngGrid'
	        function(
	            //여기에는 모듈 선언시에만 가져올 수 있는 프로바이더들을 파라메터로 넣어줄 수 있다.
	            //예 : provide, $routeProvider, $compileProvider, $controllerProvider, $filterProvider
	        ){
	            //위에서 파라메터로 넣어준 프로바이더들 통해 여기에서 프로바이더로만 해줄 수 있는 로우레벨의 작업들을 할 수 있다. 예 : route 설정
	        }
	    );
	    
	    //컨트롤러 선언. 컨트롤러는 여러개를 선언해줄 수 있다.
	    myApp.controller
	    (
	        'myController', //선언할 컨트롤러명
	        function($scope
	            //여기에는 컨트롤러에서 사용할 서비스들을 파라메터로 넣어줄 수 있다.
	            //예 : $scope, $rootScope, $location, $http ...
	        ){
	            //이 안에서 실제 여러가지 작업들을 하게 된다.
	            
	            $scope.test = "안녕하세요!";
	        }
	    );
	})();