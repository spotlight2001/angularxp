var phonecatApp = angular.module('flickrModule', [ 'ngResource' ]);
xxx
phonecatApp
		.controller(
				'FlickrCtrl',
				function($scope, $http) {

					$scope.search = function() {
						if (!$scope.searchTerm) {
							$scope.searchTerm = '';
						}
						$http
								.jsonp(
										'http://api.flickr.com/services/feeds/photos_public.gne?jsoncallback=JSON_CALLBACK&format=json&tagmode=all&tags='
												+ $scope.searchTerm).success(
										function(data) {
											console.dir(data);
											$scope.photos = data.items;
										});

					}

					$scope.selectPhoto = function(photo) {
						console.log('photo has been selected: ' + photo);
						$scope.selectedPhoto = photo;
						console.dir($scope.selectedPhoto);
					}
					
					$scope.lineBreak = function(i) {
						var doLineBreak = i % 3 == 0;
						console.log('doLineBreak: ' + doLineBreak + ', on index: ' + i);
						return doLineBreak;
					}

					$scope.photos = [];
				});