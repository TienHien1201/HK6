const itemCoffes = [
  {
    id: 1,
    name: 'Bạc Xỉu Đá',
    image: require('@/assets/food_menu/BAC_XIU.png'),
    description:
      'Bạc Xỉu Đá là một sự lựa chọn nhẹ “đô" cà phê nhưng vẫn thơm ngon, chất lừ không kém!',
    price: '29,000 VNĐ',
    quality: 6,
    size: [
      { type: 'Nhỏ', price: '29,000 VNĐ' }, // Giá không đổi
      { type: 'Vừa', price: '33,000 VNĐ' }, // Giá + 4,000 VNĐ
      { type: 'To', price: '43,000 VNĐ' }, // Giá + 14,000 VNĐ
    ],    
  },
  {
    id: 2,
    name: 'Caramel Macchiato',
    image: require('@/assets/food_menu/CARAMEL_MACCHIATTO.png'),
    description:
      'Ly cà phê Caramel Macchiato bắt đầu từ dòng sữa tươi và lớp bọt sữa béo ngậy, sau đó hòa quyện cùng cà phê espresso đậm đà và sốt caramel ngọt ngào',
    price: '69,000 VNĐ',
    quality: 7,
    size: [
      { type: 'Nhỏ', price: '69,000 VNĐ' },
      { type: 'Vừa', price: '73,000 VNĐ' },
      { type: 'To', price: '83,000 VNĐ' },
    ],
  },
  {
    id: 3,
    name: 'Latte',
    image: require('@/assets/food_menu/LATTE_1.png'),
    description:
      'Latte của chúng tôi bắt đầu với cà phê espresso, sau đó thêm sữa tươi và bọt sữa một cách đầy nghệ thuật',
    price: '65,000 VNĐ',
    quality: 5,
    size: [
      { type: 'Nhỏ', price: '65,000 VNĐ' },
      { type: 'Vừa', price: '69,000 VNĐ' },
      { type: 'To', price: '79,000 VNĐ' },
    ],
  },
  {
    id: 4,
    name: 'Espresso',
    image: require('@/assets/food_menu/EXPRESSO.png'),
    description:
      ' Được chiết xuất một cách hoàn hảo từ loại cà phê rang được phối trộn độc đáo từ những hạt cà phê Robusta và Arabica chất lượng hảo hạng.',
    price: '45,000 VNĐ',
    quality: 9,
    size: [
      { type: 'Nhỏ', price: '45,000 VNĐ' },
      { type: 'Vừa', price: '49,000 VNĐ' },
      { type: 'To', price: '59,000 VNĐ' },
    ],
  },
  {
    id: 5,
    name: 'Americano',
    image: require('@/assets/food_menu/AMERICANO_NONG.png'),
    description:
      'Americano tại Highlands Coffee là sự kết hợp giữa cà phê espresso thêm vào nước đun sôi',
    price: ' 45,000 VNĐ',
    quality: 1,
    size: [
      { type: 'Nhỏ', price: '45,000 VNĐ' },
      { type: 'Vừa', price: '49,000 VNĐ' },
      { type: 'To', price: '59,000 VNĐ' },
    ],
  },
  {
    id: 6,
    name: 'Phin Sữa Đá',
    image: require('@/assets/food_menu/PHIN_SUADA.png'),
    description:
      'Cà phê được pha từ Phin truyền thống, hoà cùng sữa đặc sánh và thêm vào chút đá tạo nên ly Phin Sữa Đá – Đậm Đà Chất Phin.',
    price: '29,000 VNĐ',
    quality: 3,
    size: [
      { type: 'Nhỏ', price: '29,000 VNĐ' },
      { type: 'Vừa', price: '33,000 VNĐ' },
      { type: 'To', price: '43,000 VNĐ' },
    ],
  },
  {
    id: 7,
    name: 'Cappuccino',
    image: require('@/assets/food_menu/CAPPUCINO.png'),
    description:
      'Một chút đậm đà hơn so với Latte, Cappuccino của chúng tôi bắt đầu với cà phê espresso, sau đó thêm một lượng tương đương giữa sữa tươi và bọt sữa cho thật hấp dẫn',
    price: '65,000 VNĐ',
    quality: 2,
    size: [
      { type: 'Nhỏ', price: '65,000 VNĐ' },
      { type: 'Vừa', price: '69,000 VNĐ' },
      { type: 'To', price: '79,000 VNĐ' },
    ],
  },
  {
    id: 8,
    name: 'Mocha Macchiato',
    image: require('@/assets/food_menu/MOCHA.png'),
    description:
      'Một thức uống yêu thích được kết hợp bởi giữa sốt sô cô la ngọt ngào, sữa tươi và đặc biệt là cà phê espresso đậm đà',
    price: '69,000 VNĐ',
    quality: 7,
    size: [
      { type: 'Nhỏ', price: '69,000 VNĐ' },
      { type: 'Vừa', price: '73,000 VNĐ' },
      { type: 'To', price: '83,000 VNĐ' },
    ],
  },
];

export default itemCoffes;
