function initUploadSetting(parms){
	return {
		flash_url : $("#APP_STATIC_PATH").val() + "/mui/widgets/swfupload/swfupload.swf",
		upload_url: parms.upload_url?parms.upload_url:$("#APP_ROOT_PATH").val() + "file/upload",
		post_params: parms.post_params,
		file_size_limit : "100 MB",
		file_types : "*.*",
		file_types_description : "All Files",
		file_upload_limit : parms.file_upload_limit?parms.file_upload_limit:1,
		file_queue_limit : 0,
		custom_settings : {
			progressTarget : "fsUploadProgress",
			cancelButtonId : "btnCancel"
		},
		debug: false,

		// Button Settings
//		button_text:parms.button_text?parms.button_text:"",
		button_image_url : parms.button_image_url?parms.button_image_url:$("#APP_STATIC_PATH").val() + "/images/btn_upload.png",
		
		button_placeholder_id : parms.button_placeholder_id,
		button_width: parms.button_width?parms.button_width:99,
		button_height: parms.button_height?parms.button_height:29,

		// The event handler functions are defined in handlers.js
		swfupload_loaded_handler : swfUploadLoaded,
		file_queued_handler : fileQueued,
		file_queue_error_handler : fileQueueError,
		file_dialog_complete_handler : fileDialogComplete,
		upload_start_handler : uploadStart,
		upload_progress_handler : uploadProgress,
		upload_error_handler : uploadError,
		upload_success_handler : uploadSuccess,
		mySuccessFun:parms.mySuccessFun,
		upload_complete_handler : uploadComplete,
		queue_complete_handler : queueComplete,	// Queue plugin event
		
		// SWFObject settings
		minimum_flash_version : "9.0.28",
		swfupload_pre_load_handler : swfUploadPreLoad,
		swfupload_load_failed_handler : swfUploadLoadFailed
	};
}