console.clear();

var nodes = document.getElementsByTagName("div");
//alert(nodes.length);

var node = document.getElementById("div2");
//alert(node1.textContent);

var nodes = document.getElementsByClassName("class1");
//alert(nodes2.length);

var div_1 = document.createElement("div");
div_1.setAttribute("id", "Jacky");


var product = {};
product.price = 500.5;
product.brand = "Tesla";
product.isVip = true;

console.log('x' in window);

for (attr in product) {
    console.log(product[attr]);
}

