const itemTeas = [
  {
    id: 9,
    name: 'Trà Thạch Vải',
    image: require('@/assets/food_menu/TRA_TACH_VAI.png'),
    description:
      'Một sự kết hợp thú vị giữa trà đen, những quả vải thơm ngon và thạch giòn khó cưỡng, mang đến thức uống tuyệt hảo!',
    price: '45,000 VNĐ',
    quality: 10,
    size: [
      { type: 'Nhỏ', price: '45,000 VNĐ' },
      { type: 'Vừa', price: '49,000 VNĐ' }, // 45,000 + 4,000
      { type: 'To', price: '59,000 VNĐ' }, // 45,000 + 14,000
    ],
  },
  {
    id: 10,
    name: 'Trà Sen Vàng (Củ Năng)',
    image: require('@/assets/food_menu/TRA_SEN_VANG_CU_NANG.png'),
    description:
      'Thức uống chinh phục những thực khách khó tính! Sự kết hợp độc đáo giữa trà Ô long, hạt sen thơm bùi và củ năng giòn tan. Thêm vào chút sữa sẽ để vị thêm ngọt ngào.',
    price: '45,000 VNĐ',
    quality: 11,
    size: [
      { type: 'Nhỏ', price: '45,000 VNĐ' },
      { type: 'Vừa', price: '49,000 VNĐ' }, // 45,000 + 4,000
      { type: 'To', price: '59,000 VNĐ' }, // 45,000 + 14,000
    ],
  },
  {
    id: 11,
    name: 'Trà Thạch Đào',
    image: require('@/assets/food_menu/TRA_THANH_DAO.png'),
    description:
      'Vị trà đậm đà kết hợp cùng những miếng đào thơm ngon mọng nước cùng thạch đào giòn dai. Thêm vào ít sữa để gia tăng vị béo.',
    price: '45,000 VNĐ',
    quality: 5,
    size: [
      { type: 'Nhỏ', price: '45,000 VNĐ' },
      { type: 'Vừa', price: '49,000 VNĐ' }, // 45,000 + 4,000
      { type: 'To', price: '59,000 VNĐ' }, // 45,000 + 14,000
    ],
  },
  {
    id: 12,
    name: 'Trà Thanh Đào',
    image: require('@/assets/food_menu/TRA_THANH_DAO.png'),
    description:
      'Một trải nghiệm thú vị khác! Sự hài hòa giữa vị trà cao cấp, vị sả thanh mát và những miếng đào thơm ngon mọng nước sẽ mang đến cho bạn một thức uống tuyệt vời.',
    price: '45,000 VNĐ',
    quality: 7,
    size: [
      { type: 'Nhỏ', price: '45,000 VNĐ' },
      { type: 'Vừa', price: '49,000 VNĐ' }, // 45,000 + 4,000
      { type: 'To', price: '59,000 VNĐ' }, // 45,000 + 14,000
    ],
  },
  {
    id: 13,
    name: 'Freeze Trà Xanh',
    image: require('@/assets/food_menu/FREEZE_TRA_XANH.png'),
    description:
      'Thức uống rất được ưa chuộng! Trà xanh thượng hạng từ cao nguyên Việt Nam, kết hợp cùng đá xay, thạch trà dai dai, thơm ngon và một lớp kem dày phủ lên trên vô cùng hấp dẫn. Freeze Trà Xanh thơm ngon, mát lạnh, chinh phục bất cứ ai!',
    price: '55,000 VNĐ',
    quality: 9,
    size: [
      { type: 'Nhỏ', price: '55,000 VNĐ' },
      { type: 'Vừa', price: '59,000 VNĐ' }, // 55,000 + 4,000
      { type: 'To', price: '69,000 VNĐ' }, // 55,000 + 14,000
    ],
  },
  {
    id: 14,
    name: 'Trà Xanh Đậu Đỏ',
    image: require('@/assets/food_menu/TRA_XANH_DAU_DO.png'),
    description:
      'Trà đậu đỏ được pha truyền thống, hoà cùng đậu đỏ và thêm vào chút đá tạo nên ly Trà đậu đỏ – Đậm Đà Chất lượng.',
    price: '45,000 VNĐ',
    quality: 4,
    size: [
      { type: 'Nhỏ', price: '45,000 VNĐ' },
      { type: 'Vừa', price: '49,000 VNĐ' }, // 45,000 + 4,000
      { type: 'To', price: '59,000 VNĐ' }, // 45,000 + 14,000
    ],
  },
  {
    id: 15,
    name: 'Trà Sen Vàng (Sen)',
    image: require('@/assets/food_menu/SenVangSen.png'),
    description: 'Thật hấp dẫn',
    price: '65,000 VNĐ',
    quality: 3,
    size: [
      { type: 'Nhỏ', price: '65,000 VNĐ' },
      { type: 'Vừa', price: '69,000 VNĐ' }, // 65,000 + 4,000
      { type: 'To', price: '79,000 VNĐ' }, // 65,000 + 14,000
    ],
  },
  {
    id: 16,
    name: 'TRÀ QUẢ MỌNG ANH ĐÀO',
    image: require('@/assets/food_menu/Tra_Qua_Mong_Anh_Dao.png'),
    description: 'Một thức uống yêu thích',
    price: '79,000 VNĐ',
    quality: 6,
    size: [
      { type: 'Nhỏ', price: '79,000 VNĐ' },
      { type: 'Vừa', price: '83,000 VNĐ' }, // 79,000 + 4,000
      { type: 'To', price: '93,000 VNĐ' }, // 79,000 + 14,000
    ],
  },
  {
    id: 17,
    name: 'TRÀ QUẢ MỌNG ANH ĐÀO',
    image: require('@/assets/food_menu/Tra_Qua_Mong_Anh_Dao.png'),
    description: 'Một thức uống yêu thích',
    price: '79,000 VNĐ',
    quality: 6,
    size: [
      { type: 'Nhỏ', price: '79,000 VNĐ' },
      { type: 'Vừa', price: '83,000 VNĐ' }, // 79,000 + 4,000
      { type: 'To', price: '93,000 VNĐ' }, // 79,000 + 14,000
    ],
  },
  {
    id: 18,
    name: 'TRÀ QUẢ MỌNG ANH ĐÀO',
    image: require('@/assets/food_menu/Tra_Qua_Mong_Anh_Dao.png'),
    description: 'Một thức uống yêu thích',
    price: '79,000 VNĐ',
    quality: 6,
    size: [
      { type: 'Nhỏ', price: '79,000 VNĐ' },
      { type: 'Vừa', price: '83,000 VNĐ' }, // 79,000 + 4,000
      { type: 'To', price: '93,000 VNĐ' }, // 79,000 + 14,000
    ],
  },
];

export default itemTeas;
