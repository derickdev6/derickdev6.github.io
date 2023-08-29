function isElementInViewport(element) {
    const rect = element.getBoundingClientRect();
    return (
      rect.top >= 0 &&
      rect.left >= 0 &&
      rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
      rect.right <= (window.innerWidth || document.documentElement.clientWidth)
    );
  }
  
  function handleVisibility() {
    const fadeElements = document.querySelectorAll('.fade-in-element');
    fadeElements.forEach(element => {
      if (isElementInViewport(element)) {
        element.classList.add('visible');
      }
    });
  }
  
  window.addEventListener('scroll', handleVisibility);
  window.addEventListener('load', handleVisibility);
  