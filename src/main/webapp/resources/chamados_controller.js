/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

var app = angular.module("chamadosApp",[]);

app.controller("chamadosController", function ($scope, $http,apiValues){
    $scope.teste = "Teste app";
    $scope.chamado;
    $scope.chamados = [];
    $scope.erro;
    
    $scope.salvar = function(chamado){
        var requisicao = chamado.id?$http.put(apiValues.baseUrl,chamado):$http.post(apiValues.baseUrl,chamado);
        requisicao.then(function (retorno){
            $scope.cancelar();
            $scope.getChamados();
        }, (retorno)=> $scope.setErro("erro salvar" + retorno));
    };
    
    $scope.getChamado = function(id){
        $http.get(apiValues.baseUrl+id+"/").then(function (retorno){
            $scope.chamado = retorno.data;
        }, (retorno)=> $scope.setErro("erro getChamado" + retorno));  
    };
    
    $scope.getChamados = function(){
        $http.get(apiValues.baseUrl).then(function (retorno){
            $scope.chamados = retorno.data;
        });  
    }, (retorno)=> $scope.setErro("erro getChamados" + retorno);
    
     $scope.deletar = function(id){
        $http.delete(apiValues.baseUrl+id+"/").then(function (retorno){
            $scope.getChamados();
        }, (retorno)=> $scope.setErro("erro deletar" + retorno));  
    };
    
    $scope.concluir = function(id){
       $http.put(apiValues.baseUrl+id+"/").then(function (retorno){
            $scope.getChamados();
        }, (retorno)=> $scope.setErro("erro concluir" + retorno));
    };
    
    $scope.cancelar = () => delete $scope.chamado;
    
    $scope.setErro = (erro) => erro?$scope.erro = erro: delete erro;
    
    $scope.setChamado = (chamado) => $scope.chamado = angular.copy(chamado);
    
    $scope.getChamados();
});


