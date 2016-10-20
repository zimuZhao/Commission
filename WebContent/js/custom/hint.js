/**
 * 提示信息
 * 
 * @param type
 * @param mes
 */
function hint(type, title, text) {
	var time = 2000;
	var class_name = "growl-info";
	switch (type) {
	case "S":
		//time = 2000;
		class_name = "growl-success";
		break;
	case "I":
		//time = 6000;
		class_name = "growl-info";
		break;
	case "W":
		//time = 4000;
		class_name = "growl-warning";
		break;
	case "D":
		//time = 4000;
		class_name = "growl-danger";
		break;

	default:
		break;
	}
	if(text){
		jQuery.gritter.add({
			title : title,
			text : text,
			class_name : class_name,
			sticky : false,
			time : time
		});
	}else {
		jQuery.gritter.add({
			text : title,
			class_name : class_name,
			sticky : false,
			time : time
		});
	}

}
