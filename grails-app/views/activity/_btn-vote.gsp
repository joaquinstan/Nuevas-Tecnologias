<a id="btn-vote-up-active" class="up active" href="javascript:void(0);" style="display:${activity.getUserLikeState(currentUser) == 1 ? "show" : "none" }"></a>

<a id="btn-vote-up" class="up" onclick="${remoteFunction(
      controller:'activity', 
      action:'updateLike', 
      params: "'id='+${activity.id}+'&likeState=1'", 
      onComplete:'activeBtnUp()')}" href="javascript:void(0);" style="display:${activity.getUserLikeState(currentUser) == 1 ? "none" : "show" }"></a>

<a id="btn-vote-down-active" class="second-btn down active" href="javascript:void(0);" style="display:${activity.getUserLikeState(currentUser) == -1 ? "show" : "none" }"></a></a>

<a id="btn-vote-down" class="second-btn down" onclick="${remoteFunction(
       controller:'activity', 
       action:'updateLike', 
       params: "'id='+${activity.id}+'&likeState=-1'", 
       onComplete:'activeBtnDown()')}" href="javascript:void(0);" style="display:${activity.getUserLikeState(currentUser) == -1 ? "none" : "show" }"></a>



<g:javascript>

	function activeBtnUp() {
		document.getElementById('btn-vote-up-active').style.display = 'block';
		document.getElementById('btn-vote-up').style.display = 'none';
		document.getElementById('btn-vote-down-active').style.display = 'none';
		document.getElementById('btn-vote-down').style.display = 'block';
	}

	function activeBtnDown() {
		document.getElementById('btn-vote-up-active').style.display = 'none';
		document.getElementById('btn-vote-up').style.display = 'block';
		document.getElementById('btn-vote-down-active').style.display = 'block';
		document.getElementById('btn-vote-down').style.display = 'none';
	}

</g:javascript>