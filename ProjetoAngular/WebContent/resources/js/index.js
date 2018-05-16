var app = angular.module('livraria', [ 'ngRoute' ]);

app.config(function($routeProvider) {
	$routeProvider.when("/", {
		controller : "listLivro",
		templateUrl : "list.html"
	}).when("/new", {
		controller : "addLivro",
		templateUrl : "form.html"
	}).when("/edit/:nome/:autor/:genero", {
		controller : "editLivro",
		templateUrl : "form.html"
	}).otherwise({
		redirectTo : "/"
	});
});

app.run(function($rootScope, $http) {
	$http({method : 'GET',
		url: 'list',
		headers : {'Content-Type': 'application/json'}
	}).then(function(response) {
		$rootScope.livros = response.data;
	});
});

app.controller('listLivro', function($scope) {
	$scope.title = 'Listar';

	$scope.orderByCol = function(column) {
		$scope.col = column;
	}

});

app.controller('editLivro', function($scope, $location, $routeParams) {
	$scope.title = 'Edição Livro';
	$scope.icEdicao = true;
	$scope.livro = {
		nome : $routeParams.nome,
		autor : $routeParams.autor,
		genero : $routeParams.genero
	};

	for (var i = 0; i < $scope.livros.length; i++) {
		if ($scope.livros[i].nome == $scope.livro.nome) {
			$scope.livroIndex = i;
			break;
		}
	}

	$scope.salvar = function() {
		$scope.livros[($scope.livroIndex)] = $scope.livro;
		$location.path('/');

	}
});

app.controller('addLivro', function($scope, $http, $location) {
	$scope.title = 'Novo Livro';
	$scope.icEdicao = false;
	$scope.livro = {
		nome : '',
		autor : '',
		genero : ''
	}

	$scope.salvar = function() {
		/*$scope.livros.push($scope.livro);
		$location.path('/');*/
		console.log($scope.livro.nome + ' - ' + $scope.livro.autor + ' - '+ $scope.livro.genero);
		$http({method : 'POST', url: 'salvar', data : $scope.livro,  headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		
		}).then(function(response){
			$scope.livros.push($scope.livro);
			alert('Livro adicionado com sucesso');
			console.log('sucesso');
			$location.path('/');
		});
		
		  console.log('post feito');

	}
});

app.controller('livrariaCont', function($scope) {
});
