export function getRGBFromDecimalColor(color: number) {
  let red = (color >> 16) & 0xff;
  let green = (color >> 8) & 0xff;
  let blue = color & 0xff;
  return `rgb(${red},${green},${blue})`;
}

export function makeSVGElement(
  type: string,
  attributes: Record<string, any> = {},
  parent?: any
): SVGElement {
  let element = document.createElementNS('http://www.w3.org/2000/svg', type);

  for (let prop in attributes) {
    if (!attributes.hasOwnProperty(prop)) {
      continue;
    }

    element.setAttribute(prop, attributes[prop]);
  }

  if (parent) {
    parent.appendChild(element);
  }

  return element;
}
