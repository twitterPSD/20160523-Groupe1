(function(angular) {
  var TweetController = function($scope, Tweet) {
    Tweet.query(function(response) {
      $scope.Tweets = response ? response : [];
    });
    
    $scope.addTweet = function(description) {
      new Tweet({
        description: description,
        checked: false
      }).$save(function(Tweet) {
        $scope.Tweets.push(Tweet);
      });
      $scope.newTweet = "";
    };
    
    $scope.updateTweet = function(Tweet) {
      Tweet.$update();
    };
    
    $scope.deleteTweet = function(Tweet) {
      Tweet.$remove(function() {
        $scope.Tweets.splice($scope.Tweets.indexOf(Tweet), 1);
      });
    };
  };
  
  TweetController.$inject = ['$scope', 'Tweet'];
  angular.module("myApp.controllers").controller("TweetController", TweetController);
}(angular));