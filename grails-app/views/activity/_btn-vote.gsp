<g:if test="${activity.getUserLike(currentUser) != null && activity.getUserLike(currentUser).getLikeState() == 1}">
    <a class="up active" href="javascript:void(0);"></a>
</g:if>
<g:else>
     <a class="up" onclick="${remoteFunction(
           controller:'activity', 
           action:'updateLike', 
           params: "'id='+${activity.id}+'&likeState=1'", 
           onComplete:'updatedBtnVote()')}" href="javascript:void(0);"></a>
</g:else>

<g:if test="${activity.getUserLike(currentUser) != null && activity.getUserLike(currentUser).getLikeState() == -1}">
 				<a class="second-btn down active" href="javascript:void(0);"></a></a>
</g:if>
<g:else>
 				<a class="second-btn down" onclick="${remoteFunction(
           controller:'activity', 
           action:'updateLike', 
           params: "'id='+${activity.id}+'&likeState=-1'", 
           onComplete:'updatedBtnVote()')}" href="javascript:void(0);"></a>
</g:else>