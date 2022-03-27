function eliminar(id){
    swal({
      title: 'Estas seguro que quieres Eliminar a este usuario?',
      text: "Una vez eliminado no podras recuperarlo!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((OK) => {
      if (OK) {
          $.ajax({
          url:"/eliminar/"+id,
          success: function(res){
            console.log(res);
          },
      });
        swal("Poof! El usuario fue eliminado correctamente", {
          icon: "success",
        }).then((ok)=>{
        if(ok){
            location.href="/";
        }
        });
      } else {
        swal("El usuario no fue eliminado!");
      }
    });
}