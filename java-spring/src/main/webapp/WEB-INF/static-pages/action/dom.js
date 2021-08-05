console.clear();

var nodes = document.getElementsByTagName("div");
//alert(nodes.length);

var node = document.getElementById("div2");
//alert(node1.textContent);

var nodes = document.getElementsByClassName("class1");
//alert(nodes2.length);

var div_1 = document.createElement("div");
div_1.setAttribute("id", "Jacky");


//判断 x 为全局变量
console.log("x" in window);

//创建 product 对象
var product = {
    price: 500.5,
    brand: "Tesla"
};
product.isVip = true;

//修改 product 对象属性
with (product) {
    price = 600.5;
    isVip = false;
}

//删除 product 对象属性
delete product.isVip;

//遍历 product 对象属性
for (key in product) {
    if (product.hasOwnProperty(key)) {
        console.log(product[key]);
    }
}

var objectLikeArray = {
    1: 'a',
    2: 'b'
}
console.log(objectLikeArray[1]);


/*
数组演示
*/
var box = [1, { a: 1 }, [1, 2, 3], function () { }];
console.log(box.length);

box.length = 3;
console.log(box);

box[9] = 'bbq';
console.log(box);

//box.length = 0;
//console.log(box);

//box.length = Math.pow(2, 32);

box.title = "fuck";
box["2.1"] = "version";
console.log(box.title);
console.log(box["2.1"]);

box.forEach(function (value, key) { console.log(key + " : " + value) });
delete box[1];
delete box[2];
console.log("-----------------------");
box.forEach(function (value, key) { console.log(key + " : " + value) });
console.log("-----------------------");
box[5] = undefined;
for (var key in box) { console.log(key + " : " + box[key]) };
console.log("-----------------------");
delete box[5];
console.log("11" in box);
for (var key in box) { console.log(key + " : " + box[key]) };
console.log("-----------------------");
for (var key = 0; key < box.length; key++) {
    console.log(key + " : " + box[key]);
}


/*
函数，声明提升
*/
function playMusic() {
    console.log("beautiful now");
}
playMusic();

var goToHappy = function goToClub(x, y) {
    console.log(typeof goToClub);
    return x + y;
}
goToHappy();
console.log(goToHappy.name);
console.log(goToHappy.length);
console.log(goToHappy.toString());



