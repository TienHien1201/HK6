const coffeeItems = [
  {
    id: 1,
    image: 'images/Latte.jpg',
    title: 'Iced Latte',
    description:
      'Iced Latte là thức uống kết hợp giữa espresso và sữa tươi, được pha lạnh với đá. Hương vị đậm đà của cà phê hòa quyện cùng vị béo nhẹ của sữa, tạo nên một ly cà phê mát lạnh, tươi mới và dễ uống.looking at its layout. The point of',
    linkText: 'Read More',
    price: 950000,
    quality: 9,
  },
  {
    id: 2,
    image: 'images/Cappuchino.jpg',
    title: 'Iced Cappuchino',
    description:
      'Iced Cappuccino là phiên bản lạnh của cappuccino, gồm espresso, sữa tươi, và một lớp bọt sữa dày bên trên, sau đó thêm đá. Thức uống này mang đến hương vị cà phê đậm đà, béo ngậy và mát lạnh, với kết cấu bọt sữa bông xốp đặc trưng.',
    linkText: 'Read More',
    price: 95000,
    quality: 3,
  },
  {
    id: 3,
    image: 'images/Americano.jpg',
    title: 'Iced Americano ',
    description:
      'Iced Americano là thức uống kết hợp giữa espresso và nước lạnh, sau đó thêm đá. Hương vị đậm đà, mạnh mẽ của cà phê espresso được làm dịu đi nhưng vẫn giữ nguyên độ thơm ngon, mang đến cảm giác sảng khoái và tươi mát.',
    linkText: 'Read More',
    price: 80000,
    quality: 7,
  },
  {
    id: 4,
    image: 'images/Mocha.jpg',
    title: 'Iced Mocha',
    description:
      'Iced Mocha là sự kết hợp giữa espresso, sữa tươi, sốt chocolate và đá. Thức uống có hương vị đậm đà của cà phê, vị ngọt ngào của chocolate, cùng với độ béo nhẹ của sữa, tạo nên một ly cà phê mát lạnh, thơm ngon và hấp dẫn.',
    linkText: 'Read More',
    price: 95000,
    quality: 6,
  },
  {
    id: 5,
    image: 'images/StrawberryEspressoTonic.jpg',
    title: 'Strawberry Espresso Tonic',
    description:
      'Strawberry Espresso Tonic là thức uống sáng tạo kết hợp giữa espresso, nước tonic, và sốt dâu tây. Ly đồ uống có vị đắng nhẹ của cà phê, vị chua ngọt từ dâu tây, và cảm giác sảng khoái từ tonic. Được phục vụ lạnh với đá, thức uống này mang đến hương vị tươi mới, độc đáo và đầy kích thích vị giác.',
    linkText: 'Read More',
    price: 90000,
    quality: 6,
  },
  {
    id: 6,
    image: 'images/Cocopresso.jpg',
    title: 'Cocopresso',
    description:
      'Cocopresso là sự pha trộn giữa espresso và nước dừa tươi, thường được phục vụ lạnh với đá. Thức uống này mang hương vị đậm đà của cà phê, hòa quyện cùng vị thanh mát, ngọt tự nhiên từ dừa, tạo nên trải nghiệm độc đáo, tươi mới và đầy năng lượng.',
    linkText: 'Read More',
    price: 85000,
    quality: 6,
  },
  {
    id: 7,
    image: 'images/DalgonaCoffee.jpg',
    title: 'Dalgona Coffe',
    description:
      'Dalgona Coffee là thức uống nổi tiếng với lớp bọt cà phê sánh mịn, được làm từ cà phê hòa tan, đường, và nước nóng, đánh bông cho đến khi tạo thành lớp kem mịn. Lớp bọt này được đổ lên trên sữa tươi lạnh hoặc nóng, tạo nên hương vị đậm đà, béo ngậy, với sự tương phản giữa vị đắng nhẹ của cà phê và vị ngọt từ sữa.',
    linkText: 'Read More',
    price: 85000,
    quality: 6,
  },
  {
    id: 8,
    image: 'images/SaltedCoffee.jpg',
    title: 'Salted Coffee',
    description:
      'Salted Coffee là sự kết hợp độc đáo giữa cà phê đen và một lớp kem tươi có muối biển. Vị đắng của cà phê hòa quyện với vị béo mịn của kem và chút mặn nhẹ, tạo nên hương vị cân bằng, thú vị, mang đến trải nghiệm mới lạ nhưng vẫn đầy cuốn hút. Thức uống này thường được phục vụ lạnh với đá.',
    linkText: 'Read More',
    price: 85000,
    quality: 6,
  },
  {
    id: 9,
    image: 'images/MatchaLatte.jpg',
    title: 'Matcha Latte',
    description:
      'Matcha Latte là thức uống kết hợp giữa bột matcha (trà xanh Nhật Bản) và sữa tươi, có thể được phục vụ nóng hoặc lạnh. Vị trà xanh thanh mát, hơi đắng nhẹ, hòa quyện cùng vị béo ngậy của sữa, tạo nên một ly đồ uống thơm ngon, mịn màng và đầy năng lượng. Thường được trang trí với một lớp bọt sữa mịn hoặc bột matcha rắc lên trên.  ',
    linkText: 'Read More',
    price: 85000,
    quality: 6,
  },
  {
    id: 10,
    image: 'images/PandanCoconutMilk Tea.jpg',
    title: 'Pandan Coconut Milk Tea ',
    description:
      'Pandan Coconut Milk Tea là thức uống trà sữa kết hợp giữa trà (thường là trà đen hoặc trà xanh) với sữa dừa và hương pandan thơm mát. Hương vị đặc trưng của pandan mang đến sự tươi mới, kết hợp với sự béo ngậy của sữa dừa và vị trà đậm đà, tạo ra một thức uống thơm ngon, mượt mà và dễ uống. Thức uống này thường được phục vụ lạnh với đá và có thể thêm trân châu hoặc các topping khác tùy theo sở thích.',
    linkText: 'Read More',
    price: 90000,
    quality: 6,
  },
];

export default coffeeItems;
