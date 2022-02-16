var url = "https://api.spotify.com/v1/artists/5NGO30tJxFlKixkPSgXcFE";
var album = "https://api.spotify.com/v1/albums/7yDxJXFPl88Dt9kBo0dDD6";
var clientId = 'bd635ea57fa943b49631ec18eab5ebc8';
var clientSecret = '9422b1f545e143b2bf83c9008497ab7e';
var token = 'BQA0NriyRI-bp683MakW6Xh5n8wuvm5UWIwvGnHIS1CQDKFztK1BFGc3dCfAAd2_DmKHNtdvwYyS6RWSnkeZ3bv1sxpSFAoQiIEFL6NeJXqPhALmF-i8ahB-macIccJw3uTR2VYaI4U8z75razw6cA'

//Note that the spotify token above expires after only ONE HOUR.  Find a way to either refresh or use a longer-lasting one.


$(document).ready(function(){

  $.ajax({
    url: url,
    type: 'GET',
    data: {
        grant_type: "authorization_code",
      },
    headers: {
        'Content-Type' : 'application/x-www-form-urlencoded', 
        // 'Authorization' : 'Basic ' + btoa( clientId + ':' + clientSecret)
        'Authorization' : `Bearer ${token}`
    },
    dataType: 'json',
    error: function(){
        console.log('JSON FAILED for data');
    },
    
    
    success:function(results) {
  
      var profile = document.getElementById("police")
      console.log(results);
            
      {
      profile.insertAdjacentHTML('beforeend',"<div>" + results.name + "</div>")
      profile.insertAdjacentHTML('beforeend',"<div>" + results.popularity + "</div>");
      };

    }  
   }) 


   $.ajax({
    url: album,
    type: 'GET',
    data: {
        grant_type: "authorization_code",
      },
    headers: {
        'Content-Type' : 'application/x-www-form-urlencoded', 
        // 'Authorization' : 'Basic ' + btoa( clientId + ':' + clientSecret)
        'Authorization' : `Bearer ${token}`
    },
    dataType: 'json',
    error: function(){
        console.log('JSON FAILED for data');
    },
    
    success:function(results) {
  
      var album = document.getElementById("#synchronicity")
      console.log(results);
      
      {
        album.insertAdjacentHTML('beforeend',"<div>" + results.name + "</div>")
      }

      	
        var k = 0;
        results.tracks.items.forEach(function(k) {
            album.insertAdjacentHTML('beforeend',"<div>" + k.name + "</div>")
            k++
      })
      	
      	
      	
      	var table = document.getElementById("#synchronicity2")
      
		j = 0;
	    results.tracks.items.forEach(function(j) {
	        table.insertAdjacentHTML('beforeend',"<td>" + j.name + "</td>" + "<br>")
	        j++
      })

    }  
   })


    


 }) // end of $(document).ready() function
