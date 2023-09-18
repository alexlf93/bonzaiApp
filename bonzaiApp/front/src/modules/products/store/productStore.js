export const useCounterStore = defineStore('counter', {
    state: () => ({ 
        products: 0, 
        }),
    getters: {
      doubleCount: (state) => state.count * 2,
    },
    actions: {
      fethProducts() {
      },
    },
  })