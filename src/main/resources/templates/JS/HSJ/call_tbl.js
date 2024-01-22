$('#tr_pr_category').change(function(){
    var selVar = $(this).val();
    $('.tr_pr_spec').empty();

    if(selVar =='cpu'){
        $('.tr_pr_spec').load('../HYJ/Table/cpu_table.html #prod_table');
    }else if(selVar =='gpu'){
        $('.tr_pr_spec').load('../HYJ/Table/gpu_table.html #prod_table');
    }else if(selVar == 'motherboard'){
        $('.tr_pr_spec').load('../HYJ/Table/motherboard_table.html #prod_table');
    }else if(selVar == 'ssd'){
        $('.tr_pr_spec').load('../HYJ/Table/ssd_table.html #prod_table');                
    }else if(selVar == 'hdd'){
        $('.tr_pr_spec').load('../HYJ/Table/hdd_table.html #prod_table');                
    }else if(selVar == 'ram'){
        $('.tr_pr_spec').load('../HYJ/Table/ram_table.html #prod_table');                
    }else if(selVar == 'case'){
        $('.tr_pr_spec').load('../HYJ/Table/case_table.html #prod_table');                
    }else if(selVar == 'cooler'){
        $('.tr_pr_spec').load('../HYJ/Table/cooler_table.html #prod_table');                
    }else if(selVar == 'power'){
        $('.tr_pr_spec').load('../HYJ/Table/power_table.html #prod_table');                
    }
})