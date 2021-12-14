/**
 * 
 */

window.onload = function() {
	const allChk = document.getElementById('allChk');
	const chks = document.getElementsByName('chk');
	for (let chk in chks) {
		chks[chk].onclick = function() {
			const chksCnt = document.querySelectorAll('input[name=chk]');
			const chkedCnt = document.querySelectorAll('input[name=chk]:checked');
			console.log("chkedCnt: " + chksCnt.length);
			console.log("chkedCnt" + chkedCnt.length);

			if (chksCnt.length == chkedCnt.length) {
				allChk.checked = true;
			} else {
				allChk.checked = false;
			}
		}
		allChk.onclick = function() {

			chks.forEach((chk) => {
				chk.checked = allChk.checked
			});
		}

	}
	
}
/*function allChks(bool) {
		const chks = document.getElementsByName('chk');

		for (let c in chks) {
			chks[c].checked = bool;
		}

}*/