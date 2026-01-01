// 初始化Live2D模型
OML2D.loadOml2d({
  models: [{
    path: "live2d/models/150051_slyx_xydz/150051_slyx_xydz.model.json"
  }],
  mobileDisplay: true,  // 允许在手机端显示
  dockedPosition: "right", // 靠右显示
  menus: { disable: true },
  tips: { disable: true },
  statusBar: { disable: true }
});
